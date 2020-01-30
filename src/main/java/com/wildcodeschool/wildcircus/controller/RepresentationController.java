package com.wildcodeschool.wildcircus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.wildcircus.repository.RepresentationRepository;
@Controller
public class RepresentationController {
	
	@Autowired
	private RepresentationRepository repRepository;
	
	@GetMapping("/representation")
	public String toRepresentations(Model model) {
		model.addAttribute("representations", repRepository.findFuture());
		return "representation";
	}
	
	@GetMapping("/representation/archived")
	public String toArchivedRepresentations(Model model) {
		model.addAttribute("representations", repRepository.findPast());
		return "archivedRepresentation";
	}
	
}
