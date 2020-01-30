package com.wildcodeschool.wildcircus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String toLogin(Model model, @RequestParam (value = "error", required = false) String error) {
		if (error != null) {
			model.addAttribute("errorMessage", "Identifiants incorrects !");
		}
		return "login";
	}
}
