package com.wildcodeschool.wildcircus.controller;

import java.io.File;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.wildcircus.entity.Presentation;
import com.wildcodeschool.wildcircus.repository.PresentationRepository;
import com.wildcodeschool.wildcircus.service.FileUpload;

@Controller
public class AdminPresentationController {

	private String DIR = "presentationPicture";
	
	@Autowired
	private FileUpload fileUpload;
	
	@Autowired
	private PresentationRepository presentationRepository;
	
	@GetMapping("/admin/presentation")
	public String toAdminPresentation(Model model) {
		model.addAttribute("presentations", presentationRepository.findAll());
		return "adminPresentation";
	}
	
	@GetMapping("/admin/presentation/update")
	public String toPresentationUpdate(Model model, @RequestParam (required = false) Integer id) {
		Presentation presentation = new Presentation();
		if (id != null) {
			Optional<Presentation> optional = presentationRepository.findById(id);
        	if (optional.isPresent()) {
        		presentation = optional.get();
        	}
		}
		model.addAttribute("presentation", presentation);
		return "adminPresentationUpdate";
	}
	
	@PostMapping("/admin/presentation/update")
	public String updatePresentation(
			RedirectAttributes redirAttrs,
			@RequestParam Integer id,
			@RequestParam String title,
			@RequestParam String content,
			@RequestParam MultipartFile imageFile
			) {
		String path = "";
		if (id != null) {
			path = presentationRepository.findById(id).get().getPicturePath();
		}
		if (!imageFile.isEmpty()) {
			String fileName = DIR + File.separator + "presentation" + title.replaceAll(" ", "_").toLowerCase();
			path = fileUpload.writeFile(imageFile, DIR, fileName);
		}
		Presentation presentation = new Presentation(id, title, content, path);
		presentationRepository.save(presentation);
		if (id != null) {
			redirAttrs.addFlashAttribute("successMessage", "Le paragraphe a bien été modifié.");
		} else {
			redirAttrs.addFlashAttribute("successMessage", "Le paragraphe a bien été ajouté.");
		}
		
		return "redirect:/admin/presentation";
		
	}
	
}
