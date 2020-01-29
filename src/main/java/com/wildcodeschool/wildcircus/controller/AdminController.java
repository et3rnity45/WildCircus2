package com.wildcodeschool.wildcircus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin")
	public String toAdmin() {
		
		return "admin";
	}
	
}
