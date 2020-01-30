package com.wildcodeschool.wildcircus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wildcodeschool.wildcircus.entity.Representation;
import com.wildcodeschool.wildcircus.entity.Reservation;

@Service
public class PlaceCalculator {

	public List<int[]> calculPlaces(List<Representation> representations) {
		int adultPlaces = 0;
		int childPlaces = 0;
		int etudiantPlaces = 0;
		int schoolPlaces = 0;
		int total = 0;
		List<int[]> allPlaces = new ArrayList<>();
		
		for (Representation representation : representations) {
			adultPlaces = 0;
			childPlaces = 0;
			etudiantPlaces = 0;
			schoolPlaces = 0;
			total = 0;
			for (Reservation reservation : representation.getReservations()) {
				adultPlaces += reservation.getAdultPlaces();
				childPlaces += reservation.getChildPlaces();
				etudiantPlaces += reservation.getEtudiantPlaces();
				schoolPlaces = reservation.getSchoolPlaces();
			}
			total = adultPlaces + childPlaces + etudiantPlaces + schoolPlaces;
			int[] places = new int[] {adultPlaces, childPlaces, etudiantPlaces, schoolPlaces, total};
			allPlaces.add(places);
		}
		return allPlaces;
	}
	
}
