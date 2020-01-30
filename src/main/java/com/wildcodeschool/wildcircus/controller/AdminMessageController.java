package com.wildcodeschool.wildcircus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.wildcircus.repository.MessageRepository;

@Controller
public class AdminMessageController {

	@Autowired
	private MessageRepository messageRepository;
	
	@GetMapping("/admin/message")
	public String toAdminMessage(Model model) {
		model.addAttribute("messages", messageRepository.findAll());
		return "adminMessage";
	}
	
	@GetMapping("/admin/message/delete{id}")
	public String deleteMessage(@PathVariable int id, RedirectAttributes redirAttrs) {
		messageRepository.deleteById(id);
		redirAttrs.addFlashAttribute("successMessage", "Le message a bien été supprimé.");
		return "redirect:/admin/message";
	}
}
