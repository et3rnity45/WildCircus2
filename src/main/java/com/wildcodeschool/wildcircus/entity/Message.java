package com.wildcodeschool.wildcircus.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min = 5, max = 30, message="Nom invalide")
	private String fullname;
	@NotNull(message = "Email invalide")
	@Email(message = "Email invalide")
	private String email;
	@Column(columnDefinition = "TEXT")
	@Size(min = 5, max = 1000, message="Message trop court")
	private String content;
	private Date date;
	
	public Message() {}
	
	public Message(Integer id, String fullname, String email, String content, Date date) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.content = content;
		this.date = date;
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
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
}
