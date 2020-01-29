package com.wildcodeschool.wildcircus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.wildcircus.repository.GaleryRepository;

@Controller
public class GaleryController {
	
	@Autowired
	private GaleryRepository galeryRepository;

	@GetMapping("/galery")
	public String toGalery(Model model) {
		model.addAttribute("pictures", galeryRepository.findAll());
		
		return "galery";
	}
	
}
