package fr.ajcbanque.projetBFI.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ajcbanque.projetBFI.entities.Parametres;
import fr.ajcbanque.projetBFI.services.IParametresService;

@Controller
@RequestMapping("/perfplus")
public class PerfPlusController {
    private final IParametresService parametresService;

    @Autowired
    protected PerfPlusController(IParametresService parametresService) {
	this.parametresService = parametresService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @GetMapping("/toCreate")
    public String toCreate(@ModelAttribute("parametres") Parametres parametres,
	    Model model) {
	return "perfplus";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @PostMapping("/create")
    public String create(
	    @Valid @ModelAttribute("parametres") Parametres parametres,
	    BindingResult result, Model model) {
	parametresService.save(parametres);
	return "perfplus";
    }
}
