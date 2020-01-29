package com.wildcodeschool.wildcircus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String toHome() {
		
		return "home";
	}

}
