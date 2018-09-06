package fr.ajcbanque.projetBFI.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import fr.ajcbanque.projetBFI.entities.Client;
import fr.ajcbanque.projetBFI.entities.DemandeFinancement;
import fr.ajcbanque.projetBFI.entities.User;
import fr.ajcbanque.projetBFI.services.IClientService;
import fr.ajcbanque.projetBFI.services.IDemandeFiService;

@Controller
@RequestMapping("/demandefi")
public class DemandeController extends BaseController {
    private final IDemandeFiService demandeFiService;
    private final IClientService    clientService;

    @Autowired
    protected DemandeController(IDemandeFiService demandeFiService,
	    IClientService clientService) {
	this.demandeFiService = demandeFiService;
	this.clientService = clientService;
    }

    @GetMapping("/toCreate")
    public String toCreate(
	    @ModelAttribute("demandeFinancement") DemandeFinancement demandeFi,
	    Model model) {
	User user = getUser();
	Long id = clientService.findIdClientByUser(user.getId()); // service
	Client client = demandeFi.getClient();
	client.setId(id);
	return "demandeFiCreate";
    }

    @GetMapping("/create")
    public String create(
	    @Valid @ModelAttribute("demandeFinancement") DemandeFinancement demandeFi,
	    BindingResult result, Model model) {
	if (validateAndSave(demandeFi, result)) {
	    model.addAttribute("demandeFinancement", new DemandeFinancement());
	}
	return "demandeFiCreate";
    }

    @GetMapping("/toUpdate")
    public String toUpdate(@RequestParam("id") Long id, Model model) {
	DemandeFinancement demandeFi = demandeFiService.findById(id);
	model.addAttribute("demandeFi", demandeFi);
	// populateModel(model);
	return "demandeFiUpdate";
    }

    @PostMapping("/update")
    public String update(
	    @Valid @ModelAttribute("demandeFinancement") DemandeFinancement demandeFi,
	    BindingResult result, Model model) {
	if (validateAndSave(demandeFi, result)) {
	    return "redirect:/home/welcome";
	}
	populateModel(model);
	return "demandeFiUpdate";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
	demandeFiService.deleteById(id);
	return "redirect:/home/welcome";
    }

    @GetMapping("/histoFi")
    public String histoFi(Model model) {
	List<DemandeFiDTO> financement = demandeFiService
		.findAllAsDTO(getAppLanguage());
	model.addAttribute("financements", financement);
	return "histoFi";
    }

    private void populateModel(Model model) {
	List<ClientDTO> clients = clientService.findAllAsDTO(getAppLanguage());
	model.addAttribute("clients", clients);
    }

    private boolean validateAndSave(@Valid DemandeFinancement demandeFi,
	    BindingResult result) {
	// TODO Auto-generated method stub
	return false;
    }
}
