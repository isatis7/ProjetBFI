package fr.ajcbanque.projetBFI.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import fr.ajcbanque.projetBFI.entities.Devise;
import fr.ajcbanque.projetBFI.entities.Parametres;
import fr.ajcbanque.projetBFI.entities.TypeFinancement;
import fr.ajcbanque.projetBFI.entities.User;
import fr.ajcbanque.projetBFI.services.IClientService;
import fr.ajcbanque.projetBFI.services.IDemandeFiService;
import fr.ajcbanque.projetBFI.services.IDeviseService;
import fr.ajcbanque.projetBFI.services.IParametresService;
import fr.ajcbanque.projetBFI.services.ITypeFinancementService;

@Controller
@RequestMapping("/demandefi")
public class DemandeController extends BaseController {
    private final IDemandeFiService	  demandeFiService;
    private final IClientService	  clientService;
    private final IDeviseService	  deviseService;
    private final ITypeFinancementService typeFinancementService;
    private final IParametresService	  parametresService;

    @Autowired
    protected DemandeController(IDemandeFiService demandeFiService,
	    IClientService clientService, IDeviseService deviseService,
	    ITypeFinancementService typeFinancementService,
	    IParametresService parametresService) {
	this.demandeFiService = demandeFiService;
	this.clientService = clientService;
	this.deviseService = deviseService;
	this.typeFinancementService = typeFinancementService;
	this.parametresService = parametresService;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER_CLIENT')")
    @GetMapping("/toCreate")
    public String toCreate(
	    @ModelAttribute("demandeFinancement") DemandeFinancement demandeFi,
	    Model model) {
	populateModel(model);
	return "demandeFiCreate";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER_CLIENT')")
    @PostMapping("/create")
    public String create(
	    @Valid @ModelAttribute("demandeFinancement") DemandeFinancement demandeFi,
	    BindingResult result, Model model) {
	if (validateAndSave(demandeFi, result)) {
	    model.addAttribute("demandeFinancement", new DemandeFinancement());
	    model.addAttribute("success", true);
	}
	populateModel(model);
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

    @PreAuthorize("hasRole('ROLE_USER_PRO')")
    @PostMapping("/traiterDemande")
    public String traiterDemande(
	    @Valid @ModelAttribute("demandeFinancement") DemandeFinancement demandeFinancement,
	    BindingResult result, Model model) {
	if (validateAndSaveTraiterDemande(demandeFinancement, result)) {
	    model.addAttribute("success", true);
	} else {
	    model.addAttribute("erreur", true);
	}
	return "demandeTraiter";
    }

    @PreAuthorize("hasRole('ROLE_USER_PRO')")
    @GetMapping("/toTraiter")
    public String toTraiter(@RequestParam("id") Long id, Model model) {
	DemandeFinancement demandeFinancement = demandeFiService.findById(id);
	model.addAttribute("demandeFinancement", demandeFinancement);
	populateModel(model);
	return "demandeTraiter";
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

    @PreAuthorize("hasRole('ROLE_USER_CLIENT')")
    @GetMapping("/histoFi")
    public String histoFi(Model model) {
	List<DemandeFiDTO> financements;
	User user = getUser();
	financements = demandeFiService.findByIdUserAsDTO(getAppLanguage(),
		user.getId());
	model.addAttribute("financements", financements);
	return "histoFi";
    }

    @PreAuthorize("hasRole('ROLE_USER_PRO')")
    @GetMapping("/histoFiPro")
    public String listDemandeFiBanquier(Model model) {
	List<DemandeFiDTO> financements;
	User user = getUser();
	financements = demandeFiService.findAllProAsDTO(getAppLanguage(),
		user.getId());
	model.addAttribute("financements", financements);
	return "histoFi";
    }

    @PreAuthorize("hasAnyRole('ROLE_PO', 'ROLE_ADMIN')")
    @GetMapping("/histoFiAdminPO")
    public String listDemandeFiAdminPO(Model model) {
	List<DemandeFiDTO> financements;
	financements = demandeFiService.findAllAsDTO(getAppLanguage());
	model.addAttribute("financements", financements);
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

    private boolean validateAndSaveTraiterDemande(DemandeFinancement demandeFi,
	    BindingResult result) {
	if (!result.hasErrors()) {
	    demandeFiService.save(demandeFi);
	    return true;
	}
	return false;
    }

    private boolean validateAndSave(DemandeFinancement demandeFi,
	    BindingResult result) {
	validate(demandeFi, result);
	if (!result.hasErrors()) {
	    User user = getUser();
	    Client client = user.getClient(); // trouver le client du user
					      // actuel
	    demandeFi.setDateDemande(LocalDate.now());
	    demandeFi.setUser(user);
	    Parametres param = parametresService.findById(1L);
	    BigDecimal perfPlus = calculPerfPlus(demandeFi, param, client);
	    demandeFi.setPerfPlus(perfPlus);
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
	Devise devise = demandeFi.getDevise();
	if (Long.valueOf(0L).equals(devise.getId())) {
	    result.rejectValue("devise.id", "error.commons.required");
	}
	TypeFinancement typefi = demandeFi.getTypeFinancement();
	if (Long.valueOf(0L).equals(typefi.getId())) {
	    result.rejectValue("typeFinancement.id", "error.commons.required");
	}
    }

    private BigDecimal calculPerfPlus(DemandeFinancement demandeFi,
	    Parametres param, Client client) {
	BigDecimal mf = demandeFi.getMontant();
	BigDecimal df = demandeFi.getDuree();
	BigDecimal crp = client.getPays().getRatingInterne()
		.getCoefficientRisque();
	BigDecimal crc = client.getRatingInterne().getCoefficientRisque();
	BigDecimal perf = BigDecimal.valueOf(0);
	BigDecimal a = param.getParamA();
	BigDecimal b = param.getParamB();
	BigDecimal t = BigDecimal.valueOf(10000);
	BigDecimal u = mf.divide(df, 3, RoundingMode.HALF_UP);// (mf/df)
	BigDecimal v = mf.multiply(crc);// (mf*crc)
	BigDecimal w = mf.multiply(crp);// (mf*crp)
	BigDecimal x = b.divide(a, 3, RoundingMode.HALF_UP);// (b/a)
	BigDecimal y = mf.multiply(x);// (mf*(x))
	BigDecimal z = u.add(v.add(w).add(y));// (u)+(v)+(w)+(y)
	perf = z.divide(t, 3, RoundingMode.HALF_UP);// 10000
	return perf;
    }
}
