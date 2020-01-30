package com.wildcodeschool.wildcircus.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "Nom invalide")
	private String fullname;
	@Email(message = "Mail invalide")
	@NotNull(message = "Mail invalide")
	private String email;
	private Integer childPlaces;
	private Integer adultPlaces;
	private Integer etudiantPlaces;
	private Integer schoolPlaces;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "representation_id")
	private Representation representation;
	
	public Reservation() {}
	
	public Reservation(Integer childPlaces, Integer adultPlaces, Integer etudiantPlaces, Integer schoolPlaces) {
		super();
		this.childPlaces = childPlaces;
		this.adultPlaces = adultPlaces;
		this.etudiantPlaces = etudiantPlaces;
		this.schoolPlaces = schoolPlaces;
	}

	public Reservation(Integer id, String fullname, String email, Integer childPlaces, Integer adultPlaces,
			Integer etudiantPlaces, Integer schoolPlaces, Representation representation) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.childPlaces = childPlaces;
		this.adultPlaces = adultPlaces;
		this.etudiantPlaces = etudiantPlaces;
		this.schoolPlaces = schoolPlaces;
		this.representation = representation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getChildPlaces() {
		return childPlaces;
	}

	public void setChildPlaces(Integer childPlaces) {
		this.childPlaces = childPlaces;
	}

	public Integer getAdultPlaces() {
		return adultPlaces;
	}

	public void setAdultPlaces(Integer adultPlaces) {
		this.adultPlaces = adultPlaces;
	}

	public Integer getEtudiantPlaces() {
		return etudiantPlaces;
	}

	public void setEtudiantPlaces(Integer etudiantPlaces) {
		this.etudiantPlaces = etudiantPlaces;
	}

	public Integer getSchoolPlaces() {
		return schoolPlaces;
	}

	public void setSchoolPlaces(Integer schoolPlaces) {
		this.schoolPlaces = schoolPlaces;
	}

	public Representation getRepresentation() {
		return representation;
	}

	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}
	
}
