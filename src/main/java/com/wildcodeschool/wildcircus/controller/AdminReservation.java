package com.wildcodeschool.wildcircus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wildcodeschool.wildcircus.entity.Representation;
import com.wildcodeschool.wildcircus.repository.RepresentationRepository;
import com.wildcodeschool.wildcircus.service.PlaceCalculator;

@Controller
public class AdminReservation {

	@Autowired
	private PlaceCalculator placeCalculator;
	
	@Autowired
	private RepresentationRepository repRepository;
	
	@GetMapping("/admin/reservation")
	public String toAdminReservation(Model model) {
		List<Representation> representations = repRepository.findAll();
		List<int[]> allPlaces = placeCalculator.calculPlaces(representations);
		model.addAttribute("representations", representations);
		model.addAttribute("allPlaces", allPlaces);
		return "adminReservation";
	}
	
	@GetMapping("/admin/reservation/{id}")
	public String toReservationList(@PathVariable Integer id, Model model) {
		Representation rep = repRepository.findById(id).get();
		model.addAttribute("representation", rep);
		model.addAttribute("reservations", rep.getReservations());
		return "reservationList";
	}
	
}
