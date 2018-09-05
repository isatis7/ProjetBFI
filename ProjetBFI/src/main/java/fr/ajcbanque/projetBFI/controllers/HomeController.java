package fr.ajcbanque.projetBFI.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ajcbanque.projetBFI.dto.DemandeFiDTO;
import fr.ajcbanque.projetBFI.dto.UserDTO;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {
    @GetMapping("/welcome")
    public String welcome(Model model) {
	return "welcome";
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @GetMapping("/toCreate")
    public String toCreateDemande() {
	return "demandeCreate";
    }

    @PreAuthorize("hasRole('ROLE_PRO')")
    @GetMapping("/toCreate")
    public String toListDemande(Model model) {
	List<DemandeFiDTO> demandes = demandeService
		.findAllAsDTO(getAppLanguage());
	model.addAttribute("demandes", demandes);
	return "demandeList";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/toCreate")
    public String toListUser(Model model) {
	List<UserDTO> users = userService.findAllAsDTO(getAppLanguage());
	model.addAttribute("users", users);
	return "userList";
    }
}
