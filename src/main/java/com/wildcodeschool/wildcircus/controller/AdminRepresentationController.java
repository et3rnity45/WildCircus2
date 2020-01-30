package com.wildcodeschool.wildcircus.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.wildcircus.entity.Representation;
import com.wildcodeschool.wildcircus.repository.RepresentationRepository;
import com.wildcodeschool.wildcircus.service.FileUpload;
import com.wildcodeschool.wildcircus.service.FormatDate;

@Controller
public class AdminRepresentationController {

	private String DIR = "shows";
	
	@Autowired
	FormatDate formatDate;
	
	@Autowired
	FileUpload fileUpload;
	
	@Autowired
	private RepresentationRepository representationRepository;
	
	@GetMapping("/admin/representation")
	public String toAdminRepresentation(Model model) {
		model.addAttribute("representations", representationRepository.findAll());
		return "adminRep";
	}
	
	@GetMapping("/admin/representation/delete{id}")
	public String deleteRepresentation(@PathVariable Integer id, RedirectAttributes redirAttrs) {
		Representation repToDelete = representationRepository.findById(id).get();
		fileUpload.deleteFile(repToDelete.getPicturePath());
		representationRepository.delete(repToDelete);
		redirAttrs.addFlashAttribute("successMessage", "La représentation a bien été supprimée.");
		return "redirect:/admin/representation";
	}
	
	@GetMapping("/admin/representation/update")
	public String toRepUpdate(Model model, @RequestParam (required = false) Integer id) {
		Representation representation = new Representation();
		if (id != null) {
			Optional<Representation> optional = representationRepository.findById(id);
        	if (optional.isPresent()) {
        		representation = optional.get();
        	}
		}
		model.addAttribute("representation", representation);
		return "adminRepUpdate";
	}
	
	@PostMapping("/admin/representation/update")
	public String updateRep(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("title") String title,
			@RequestParam ("picture") MultipartFile imageFile,
			@RequestParam ("description") String description,
			@RequestParam ("date") String date,
			@RequestParam ("time") String time,
			@RequestParam ("places") Integer places
			) {
		Date finalDate = formatDate.dateAndTimeToFull(date, time);
		String path = "";
		if (id != null) {
			path = representationRepository.findById(id).get().getPicturePath();
		}
		if (!imageFile.isEmpty()) {
			String fileName = title.replaceAll(" ", "_").toLowerCase();
			path = fileUpload.writeFile(imageFile, DIR, fileName);
		}
		Representation representation = new Representation(id, title, finalDate, places, description, path);
		representationRepository.save(representation);
		if (id != null) {
			redirAttrs.addFlashAttribute("successMessage", "La représentation a bien été modifié.");
		} else {
			redirAttrs.addFlashAttribute("successMessage", "La représentation a bien été ajouté.");
		}
		
		return "redirect:/admin/representation";
	}
	
}

