package fr.ajcbanque.projetBFI.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.ajcbanque.projetBFI.dto.ClientDTO;
import fr.ajcbanque.projetBFI.dto.DemandeFiDTO;
import fr.ajcbanque.projetBFI.dto.DeviseDTO;
import fr.ajcbanque.projetBFI.dto.TypeFinancementDTO;
import fr.ajcbanque.projetBFI.entities.Client;
import fr.ajcbanque.projetBFI.entities.DemandeFinancement;
import fr.ajcbanque.projetBFI.entities.Parametres;
import fr.ajcbanque.projetBFI.entities.User;
import fr.ajcbanque.projetBFI.entities.User.Role;
import fr.ajcbanque.projetBFI.services.IClientService;
import fr.ajcbanque.projetBFI.services.IDemandeFiService;
import fr.ajcbanque.projetBFI.services.IDeviseService;
import fr.ajcbanque.projetBFI.services.ITypeFinancementService;

@Controller
@RequestMapping("/demandefi")
public class DemandeController extends BaseController {
    private final IDemandeFiService	  demandeFiService;
    private final IClientService	  clientService;
    private final IDeviseService	  deviseService;
    private final ITypeFinancementService typeFinancementService;

    @Autowired
    protected DemandeController(IDemandeFiService demandeFiService,
	    IClientService clientService, IDeviseService deviseService,
	    ITypeFinancementService typeFinancementService) {
	this.demandeFiService = demandeFiService;
	this.clientService = clientService;
	this.deviseService = deviseService;
	this.typeFinancementService = typeFinancementService;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER_CLIENT', 'ROLE_ADMIN', 'ROLE_PO')")
    @GetMapping("/toCreate")
    public String toCreate(
	    @ModelAttribute("demandeFinancement") DemandeFinancement demandeFi,
	    Model model) {
	populateModel(model);
	User user = getUser();
	Long id = clientService.findIdClientByUser(user.getId());
	Client client = demandeFi.getClient();
	client.setId(id);
	return "demandeFiCreate";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER_CLIENT', 'ROLE_ADMIN')")
    @PostMapping("/create")
    public String create(
	    @ModelAttribute("demandeFinancement") DemandeFinancement demandeFi,
	    BindingResult result, Model model) {
	User user = getUser();
	Long id = clientService.findIdClientByUser(user.getId());
	Client client = demandeFi.getClient();
	client.setId(id);
	demandeFi.setDateDemande(LocalDate.now());
	demandeFi.setPerfPlus(BigDecimal.valueOf(0.52));
	populateModel(model);
	if (validateAndSave(demandeFi, result)) {
	    model.addAttribute("demandeFinancement", new DemandeFinancement());
	}
	return "demandeFiCreate";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER_CLIENT', 'ROLE_ADMIN')")
    @GetMapping("/toUpdate")
    public String toUpdate(@RequestParam("id") Long id, Model model) {
	DemandeFinancement demandeFi = demandeFiService.findById(id);
	model.addAttribute("demandeFi", demandeFi);
	populateClientModel(model);
	populateModel(model);
	return "demandeFiUpdate";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER_CLIENT', 'ROLE_ADMIN')")
    @PostMapping("/update")
    public String update(
	    @Valid @ModelAttribute("demandeFinancement") DemandeFinancement demandeFi,
	    BindingResult result, Model model) {
	if (validateAndSave(demandeFi, result)) {
	    return "redirect:/home/welcome";
	}
	populateClientModel(model);
	populateModel(model);
	return "demandeFiUpdate";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
	demandeFiService.deleteById(id);
	return "redirect:/home/welcome";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/histoFi")
    public String histoFi(Model model) {
	List<DemandeFiDTO> financements;
	User user = getUser();
	if (user.getRole().equals(Role.ROLE_USER_CLIENT)) {
	    financements = demandeFiService
		    .findAllAsClientDTO(getAppLanguage());
	    model.addAttribute("financements", financements);
	}
	if (user.getRole().equals(Role.ROLE_USER_PRO)) {
	    financements = demandeFiService.findAllAsProDTO(getAppLanguage());
	    model.addAttribute("financements", financements);
	}
	return "histoFi";
    }

    private void populateClientModel(Model model) {
	List<ClientDTO> clients = clientService.findAllAsDTO(getAppLanguage());
	model.addAttribute("clients", clients);
    }

    private void populateModel(Model model) {
	List<DeviseDTO> devises = deviseService.findAllAsDTO(getAppLanguage());
	model.addAttribute("devises", devises);
	List<TypeFinancementDTO> types = typeFinancementService
		.findAllAsDTO(getAppLanguage());
	model.addAttribute("types", types);
    }

    private boolean validateAndSave(@Valid DemandeFinancement demandeFi,
	    BindingResult result) {
	validate(demandeFi, result);
	if (!result.hasErrors()) {
	    demandeFiService.save(demandeFi);
	    return true;
	}
	return false;
    }

    private void validate(DemandeFinancement demandeFi, BindingResult result) {
	if (!demandeFiService.validateReference(demandeFi)) {
	    result.rejectValue("reference",
		    "error.entities.demandeFi.duplicateReference");
	}
    }

    private BigDecimal calculPerfPlus (DemandeFinancement demandeFi, Parametres param) {
	BigDecimal mf = demandeFi.getMontant();
	BigDecimal df = demandeFi.getDuree();
	BigDecimal crp = demandeFi.getClient().getPays().getRatingInterne().getCoefficientRisque();
	BigDecimal crc = demandeFi.getClient().getRatingInterne().getCoefficientRisque();
	BigDecimal perf = BigDecimal.valueOf(0);
	BigDecimal a = param.getParamA();
	BigDecimal b = param.getParamB();
	BigDecimal u =;//(mf/df)
	BigDecimal v =;//(mf*crc)
	BigDecimal w =;//(mf*crp)
	BigDecimal x =;//(b/a)
	BigDecimal y =;//(mf*(x))
	BigDecimal z =;//(u)+(v)+(w)+(y)
	perf = z.divide( 10000, 3);//10000
	return perf;
    }
}
