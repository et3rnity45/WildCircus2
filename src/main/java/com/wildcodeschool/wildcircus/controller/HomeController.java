package com.wildcodeschool.wildcircus.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.wildcodeschool.wildcircus.entity.Message;
import com.wildcodeschool.wildcircus.repository.MessageRepository;
import com.wildcodeschool.wildcircus.repository.PresentationRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PresentationRepository presentationRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@GetMapping("/")
	public String toHome(Model model) {
		model.addAttribute("presentations", presentationRepository.findAll());
		model.addAttribute("message", new Message());
		return "home";
	}
	
	@PostMapping("/")
	public String sendMessage(Model model, @Valid Message message, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", message);
		} else {
			message.setDate(new Date());
			messageRepository.save(message);
			model.addAttribute("successMessage", "Votre message a bien été envoyé");
		}
		model.addAttribute("presentations", presentationRepository.findAll());
		return "home";
	}

}
