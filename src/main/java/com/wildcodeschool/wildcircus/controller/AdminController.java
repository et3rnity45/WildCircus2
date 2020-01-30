package com.wildcodeschool.wildcircus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.wildcircus.repository.MessageRepository;
import com.wildcodeschool.wildcircus.repository.ReservationRepository;

@Controller
public class AdminController {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@GetMapping("/admin")
	public String toAdmin(Model model) {
		model.addAttribute("reservationCount", reservationRepository.count());
		model.addAttribute("messageCount", messageRepository.count());
		return "admin";
	}
	
}
