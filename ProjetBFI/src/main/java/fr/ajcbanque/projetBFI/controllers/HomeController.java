package fr.ajcbanque.projetBFI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ajcbanque.projetBFI.dto.UserDTO;
import fr.ajcbanque.projetBFI.entities.User.Role;
import fr.ajcbanque.projetBFI.services.IDemandeFiService;
import fr.ajcbanque.projetBFI.services.IUserService;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {
    private final IDemandeFiService demandeFiService;
    private final IUserService	    userService;

    @Autowired
    protected HomeController(IDemandeFiService demandeFiService,
	    IUserService userService) {
	this.demandeFiService = demandeFiService;
	this.userService = userService;
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
	Role role = getRole();
	if (role.isAdmin() || role.isPO()) {
	    List<UserDTO> users = userService.findUsersEnabledAsDTO();
	    model.addAttribute("users", users);
	    return "userList";
	}
	if (role.isClient()) {
	    return "redirect:/demandefi/toCreate";
	}
	if (role.isPro()) {
	    return "redirect:/demandefi/histoFiPro";
	}
	return "welcome";
    }

    @PreAuthorize("hasRole('ROLE_USER_CLIENT')")
    @GetMapping("/toCreateDemande")
    public String toCreateDemande() {
	return "demandeFiCreate";
    }

    @PreAuthorize("hasRole('ROLE_USER_PRO')")
    @GetMapping("/toListDemande")
    public String toListDemande(Model model) {
	return "redirect:/demandefi/histoFi";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PO')")
    @GetMapping("/toListUser")
    public String toListUser(Model model) {
	List<UserDTO> users = userService.findUsersEnabledAsDTO();
	model.addAttribute("users", users);
	return "userList";
    }
}
