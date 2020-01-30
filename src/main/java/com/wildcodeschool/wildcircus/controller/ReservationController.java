package com.wildcodeschool.wildcircus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.wildcircus.entity.Representation;
import com.wildcodeschool.wildcircus.entity.Reservation;
import com.wildcodeschool.wildcircus.repository.RepresentationRepository;
import com.wildcodeschool.wildcircus.repository.ReservationRepository;

@Controller
public class ReservationController {

	@Autowired
	private RepresentationRepository repRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@GetMapping("/representation/{id}/inscription")
	public String toInscription(@PathVariable Integer id, Model model) {
		model.addAttribute("representation", repRepository.findById(id).get());
		model.addAttribute(new Reservation(0, 0, 0, 0));
		return "repInscription";
	}
	
	@PostMapping("/representation/{id}/inscription")
	public String inscription(Model model, RedirectAttributes redirAttrs, @PathVariable Integer id, @Valid Reservation reservation, BindingResult result) {
		Integer total = reservation.getSchoolPlaces() + reservation.getAdultPlaces() + reservation.getChildPlaces() + reservation.getEtudiantPlaces();
		Representation representation = repRepository.findById(id).get();
		if (result.hasErrors()) {
			model.addAttribute("representation", repRepository.findById(id).get());
			model.addAttribute("reservation", reservation);
			return "repInscription";
		} else if (total > representation.getPlaces()) {
			model.addAttribute("representation", repRepository.findById(id).get());
			model.addAttribute("reservation", reservation);
			model.addAttribute("errorMessage", "Nombre de places demandées supérieure au nombre de places disponibles.");
			return "repInscription";
		} else if (total <= 0) {
			model.addAttribute("representation", repRepository.findById(id).get());
			model.addAttribute("reservation", reservation);
			model.addAttribute("errorMessage", "Nombre de places invalide.");
			return "repInscription";
		}
		representation.setPlaces(representation.getPlaces() - total);
		reservation.setRepresentation(representation);
		reservationRepository.save(reservation);
		redirAttrs.addFlashAttribute("successMessage", "Votre réservation a bien été prise en compte.");
		return "redirect:/representation";
	}
	
}
