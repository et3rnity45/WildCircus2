package com.wildcodeschool.wildcircus.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fullname;
	private String email;
	private String placeType;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "representation_id")
	private Representation representation;
	
	public Reservation() {}
	
	public Reservation(Integer id, String fullname, String email, String placeType, Representation representation) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.placeType = placeType;
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

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public Representation getRepresentation() {
		return representation;
	}

	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}
	
}
