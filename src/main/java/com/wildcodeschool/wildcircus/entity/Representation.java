package com.wildcodeschool.wildcircus.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Representation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private Date date;
	private Integer places;
	private String description;
	private String picturePath;
	@OneToMany(mappedBy = "representation", cascade = CascadeType.ALL)
	private List<Reservation> reservations;
	
	public Representation() {}
	
	public Representation(Integer id, String title, Date date, Integer places, String description, String picturePath) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.places = places;
		this.description = description;
		this.picturePath = picturePath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getPlaces() {
		return places;
	}

	public void setPlaces(Integer places) {
		this.places = places;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
}
