package fr.ajcbanque.projetBFI.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ajcbanque.projetBFI.dto.ClientCreateDTO;
import fr.ajcbanque.projetBFI.dto.CollaborateurDTO;
import fr.ajcbanque.projetBFI.dto.UserDTO;
import fr.ajcbanque.projetBFI.entities.Client;
import fr.ajcbanque.projetBFI.entities.Collaborateur;
import fr.ajcbanque.projetBFI.entities.User;
import fr.ajcbanque.projetBFI.entities.User.Role;
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

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @GetMapping("/toCreateCollaborateur")
    public String toCreateCollaborateur(@ModelAttribute("user") User user,
	    Model model) {
	populateModel(model);
	return "userCreateCollaborateur";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @PostMapping("/createCollaborateur")
    public String createCollaborateurPost() {
	return "redirect:/users/toCreateCollaborateur";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @GetMapping("/createCollaborateur")
    public String createCollaborateurGet() {
	return "redirect:/users/toCreateCollaborateur";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @PostMapping("/toPopulateCreateCollaborateur/createCollaborateur")
    public String createCollaborateur(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Model model) {
	if (validateAndSaveCollaborateur(user, result)) {
	    model.addAttribute("user", new User());
	    model.addAttribute("success", true);
	}
	if (user.getId() == null) {
	    model.addAttribute("mustreselectCollab", true);
	}
	System.out.println(user);
	populateModel(model);
	return "userCreateCollaborateur";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @GetMapping("/toPopulateCreateCollaborateur/{id}")
    public String toPopulateCreateCollaborateur(@PathVariable("id") Long id,
	    @ModelAttribute("user") User user, Model model) {
	Collaborateur collaborateur = collaborateurService.findById(id);
	user.setCollaborateur(collaborateur);
	populateModel(model);
	return "userCreateCollaborateur";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @GetMapping("/toCreateClient")
    public String toCreateClient(@ModelAttribute("user") User user,
	    Model model) {
	populateModel(model);
	return "userCreateClient";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
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

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @GetMapping("/toUpdateCollaborateur")
    public String toUpdateCollaborateur(Model model) {
	User user = userService.findById(getUser().getId());
	model.addAttribute("user", user);
	return "userUpdateCollaborateur";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @PostMapping("/updateCollaborateur")
    public String updateCollaborateur(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Model model) {
	user.setId(getUser().getId());
	if (validateAndSaveCollaborateur(user, result)) {
	    return "redirect:/home/toListUser";
	}
	return "userUpdateCollaborateur";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @GetMapping("/toUpdateClient")
    public String toUpdateClient(Model model) {
	User user = userService.findById(getUser().getId());
	model.addAttribute("user", user);
	return "userUpdateClient";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @PostMapping("/updateClient")
    public String updateClient(@Valid @ModelAttribute("user") User user,
	    BindingResult result, Model model) {
	user.setId(getUser().getId());
	if (validateAndSaveClient(user, result)) {
	    return "redirect:/home/toListUser";
	}
	return "userUpdateClient";
    }

    private void populateModel(Model model) {
	// liste collaborateurs all
	List<CollaborateurDTO> collaborateurs = collaborateurService
		.findCustomCreateUserAsDTO();
	model.addAttribute("collaborateurs", collaborateurs);
	// liste client all
	List<ClientCreateDTO> clients = clientService
		.findIdAndInfoCompletAsDTO();
	model.addAttribute("clients", clients);
	// roles collaborateur
	List<String> rolesCollaborateur = new ArrayList<>();
	rolesCollaborateur.add("ROLE_PO");
	rolesCollaborateur.add("ROLE_USER_PRO");
	model.addAttribute("rolesCollaborateur", rolesCollaborateur);
	// roles client
	List<String> rolesClient = new ArrayList<>();
	rolesClient.add("ROLE_USER_CLIENT");
	model.addAttribute("rolesClient", rolesClient);
	// liste d'utilisateurs client
	List<UserDTO> usersclient = userService.findClientsAsDTO();
	model.addAttribute("usersclient", usersclient);
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
	Role rolePO = Role.ROLE_PO;
	Role role = user.getRole();
	if (rolePO.equals(role) && user.getPorteFeuilleClients().size() > 0) {
	    result.rejectValue("porteFeuilleClients",
		    "error.user.banquier.create.porteFeuille");
	}
	if (!userService.validateEmail(user)) {
	    result.rejectValue("email", "error.entities.user.duplicateEmail");
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

    @Override
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
	binder.registerCustomEditor(List.class, "porteFeuilleClients",
		new CustomCollectionEditor(List.class) {
		    @Override
		    protected Object convertElement(Object element) {
			Long id = null;
			if (element instanceof String) {
			    id = Long.valueOf((String) element);
			} else if (element instanceof Long) {
			    id = (Long) element;
			}
			return id != null ? userService.getOne(id) : null;
		    }
		});
    }
}
