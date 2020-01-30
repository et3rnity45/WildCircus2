package com.wildcodeschool.wildcircus.controller;

import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.wildcircus.service.FileUpload;
import com.wildcodeschool.wildcircus.entity.Galery;
import com.wildcodeschool.wildcircus.repository.GaleryRepository;

@Controller
public class AdminGaleryController {

	private String DIR = "galery";
	
	@Autowired
	private GaleryRepository galeryRepository;
	
	@Autowired
	private FileUpload fileUpload;
	
	 @GetMapping("/admin/galery")
	 public String toAdminGalery(Model model) {
		 model.addAttribute("pictures", galeryRepository.findAll());
		 return "adminGalerie";
	 }
	 
	 @GetMapping("/admin/galery/delete{id}")
	 public String deletePictureGalery(@PathVariable Integer id) {
		 Galery toDelete = galeryRepository.findById(id).get();
		 fileUpload.deleteFile(toDelete.getPicturePath());
		 galeryRepository.delete(toDelete);
		 return "redirect:/admin/galery";
	 }
	 
	 @GetMapping("/admin/galery/update")
	 public String toGaleryUpdate(Model model, @RequestParam(required = false) Integer id) {
		Galery galery = new Galery();
	    	if (id != null) {
				Optional<Galery> optional = galeryRepository.findById(id);
	        	if (optional.isPresent()) {
	        		galery = optional.get();
	        	}
	    	}
			model.addAttribute("galery", galery);
		 return "adminGalerieUpdate";
	 }
	 
	 @PostMapping("/admin/galery/update")
	 public String updateGalery(
			 RedirectAttributes redirAttrs,
			 @RequestParam ("pictures") MultipartFile[] pictures
			 ) {
		 String path = "";
		 for(MultipartFile picture : pictures) {
			 String fileName = RandomStringUtils.randomAlphanumeric(10);
			 path = fileUpload.writeFile(picture, DIR, fileName);
			 Galery galery = new Galery("Photo de la troupe", path);
			 galeryRepository.save(galery);
		 }
		 redirAttrs.addFlashAttribute("successMessage", "Les photos ont bien été ajoutées.");
		 return "redirect:/admin/galery"; 
	 }
	
}
