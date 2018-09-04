package fr.ajcbanque.projetBFI.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {
    @GetMapping("/welcome")
    public String welcome(Model model) {
	return "welcome";
    }
}
