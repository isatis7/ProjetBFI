package fr.ajcbanque.projetBFI.controllers;

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

import fr.ajcbanque.projetBFI.entities.DemandeFinancement;
import fr.ajcbanque.projetBFI.services.IDemandeFiService;

@Controller
@RequestMapping("/demandefi")
public class DemandeController extends BaseController {
    private final IDemandeFiService demandeFiService;

    @Autowired
    protected DemandeController(IDemandeFiService demandeFiService) {
	this.demandeFiService = demandeFiService;
    }

    /*
     * Méthode de recupération et et de renvoie vers la page concerné
     */
    @GetMapping("/toCreate")
    public String create(
	    @Valid @ModelAttribute("demandeFinancement") DemandeFinancement demandeFi,
	    BindingResult result, Model model) {
	if (validateAndSave(demandeFi, result)) {
	    model.addAttribute("demandeFinancement", new DemandeFinancement());
	}
	populateModel(model);
	return "demandeFiCreate";
    }

    @GetMapping("/toUpdate")
    public String toUpdate(@RequestParam("id") Long id, Model model) {
	DemandeFinancement demandeFi = demandeFiService.findById(id);
	model.addAttribute("demandeFi", demandeFi);
	populateModel(model);
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

    private void populateModel(Model model) {
	// TODO Auto-generated method stub
    }

    private boolean validateAndSave(@Valid DemandeFinancement demandeFi,
	    BindingResult result) {
	// TODO Auto-generated method stub
	return false;
    }
}
