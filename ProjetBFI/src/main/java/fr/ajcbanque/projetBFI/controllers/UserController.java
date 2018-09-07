package fr.ajcbanque.projetBFI.controllers;

import java.util.ArrayList;
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

import fr.ajcbanque.projetBFI.dto.ClientCreateDTO;
import fr.ajcbanque.projetBFI.dto.CollaborateurDTO;
import fr.ajcbanque.projetBFI.entities.Client;
import fr.ajcbanque.projetBFI.entities.Collaborateur;
import fr.ajcbanque.projetBFI.entities.User;
import fr.ajcbanque.projetBFI.services.IClientService;
import fr.ajcbanque.projetBFI.services.ICollaborateurService;
import fr.ajcbanque.projetBFI.services.IUserService;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {
    private final IUserService		userService;
    private final ICollaborateurService	collaborateurService;
    private final IClientService	clientService;

    @Autowired
    protected UserController(IUserService userService,
	    ICollaborateurService collaborateurService,
	    IClientService clientService) {
	this.userService = userService;
	this.collaborateurService = collaborateurService;
	this.clientService = clientService;
    }

    @GetMapping("/toCreateCollaborateur")
    public String toCreateCollaborateur(@ModelAttribute("user") User user,
	    Model model) {
	populateModel(model);
	return "userCreateCollaborateur";
    }

    @PostMapping("/toPopulateCreateCollaborateur/createCollaborateur")
    public String createCollaborateur(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Model model) {
	if (validateAndSaveCollaborateur(user, result)) {
	    model.addAttribute("user", new User());
	    model.addAttribute("success", true);
	}
	populateModel(model);
	return "userCreateCollaborateur";
    }

    @GetMapping("/toPopulateCreateCollaborateur/{id}")
    public String toPopulateCreateCollaborateur(@PathVariable("id") Long id,
	    @ModelAttribute("user") User user, Model model) {
	Collaborateur collaborateur = collaborateurService.findById(id);
	user.setCollaborateur(collaborateur);
	populateModel(model);
	return "userCreateCollaborateur";
    }

    @GetMapping("/toCreateClient")
    public String toCreateClient(@ModelAttribute("user") User user,
	    Model model) {
	populateModel(model);
	return "userCreateClient";
    }

    @PostMapping("/createClient")
    public String createClient(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Model model) {
	if (validateAndSaveClient(user, result)) {
	    model.addAttribute("user", new User());
	    model.addAttribute("success", true);
	}
	populateModel(model);
	return "userCreateClient";
    }

    @GetMapping("/toUpdateCollaborateur")
    public String toUpdateCollaborateur(Model model) {
	User user = userService.findById(getUser().getId());
	model.addAttribute("user", user);
	return "userUpdateCollaborateur";
    }

    @PostMapping("/updateCollaborateur")
    public String updateCollaborateur(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Model model) {
	user.setId(getUser().getId());
	if (validateAndSaveCollaborateur(user, result)) {
	    return "redirect:/home/toListUser";
	}
	return "userUpdateCollaborateur";
    }

    @GetMapping("/toUpdateClient")
    public String toUpdateClient(Model model) {
	User user = userService.findById(getUser().getId());
	model.addAttribute("user", user);
	return "userUpdateClient";
    }

    @PostMapping("/updateClient")
    public String updateClient(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Model model) {
	user.setId(getUser().getId());
	if (validateAndSaveCollaborateur(user, result)) {
	    return "redirect:/home/toListUser";
	}
	return "userUpdateClient";
    }

    private void populateModel(Model model) {
	List<CollaborateurDTO> collaborateurs = collaborateurService
		.findAllAsDTO();
	model.addAttribute("collaborateurs", collaborateurs);
	List<ClientCreateDTO> clients = clientService
		.findIdAndInfoCompletAsDTO();
	model.addAttribute("clients", clients);
	List<String> rolesCollaborateur = new ArrayList<>();
	rolesCollaborateur.add("ROLE_PO");
	rolesCollaborateur.add("ROLE_USER_PRO");
	model.addAttribute("rolesCollaborateur", rolesCollaborateur);
	List<String> rolesClient = new ArrayList<>();
	rolesClient.add("ROLE_USER_CLIENT");
	model.addAttribute("rolesClient", rolesClient);
    }

    private boolean validateAndSaveCollaborateur(User user,
	    BindingResult result) {
	validateCreateCollaborateur(user, result);
	if (!result.hasErrors()) {
	    userService.save(user);
	    return true;
	} else {
	    System.out.println(result.getAllErrors());
	}
	return false;
    }

    private boolean validateAndSaveClient(User user, BindingResult result) {
	validateCreateClient(user, result);
	if (!result.hasErrors()) {
	    userService.save(user);
	    return true;
	}
	return false;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @GetMapping("/disable/{id}")
    public String disable(@PathVariable("id") Long id) {
	userService.disable(id);
	return "redirect:/home/welcome";
    }

    private void validateCreateCollaborateur(User user, BindingResult result) {
	Collaborateur collaborateur = user.getCollaborateur();
	if (Long.valueOf(0L).equals(collaborateur.getId())) {
	    result.rejectValue("collaborateur.id", "error.commons.required");
	}
    }

    private void validateCreateClient(User user, BindingResult result) {
	Client client = user.getClient();
	if (Long.valueOf(0L).equals(client.getId())) {
	    result.rejectValue("client.id", "error.commons.required");
	}
	if (!userService.validateEmail(user)) {
	    result.rejectValue("email", "error.entities.user.duplicateEmail");
	}
    }
}
