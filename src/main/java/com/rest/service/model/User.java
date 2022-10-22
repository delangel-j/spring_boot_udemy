package com.rest.service.model;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	private int id_user;
	@Size(min = 2, message = "Name should have at least 2 characters")
	private String name;
	@Past(message = "Birthdate should be in the past")
	private LocalDate birthdate;
	
	public User() {
		super();
	}

	public User(int id, String name, LocalDate birthdate) {
		super();
		this.id_user = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	public int getId() {
		return id_user;
	}

	public void setId(int id) {
		this.id_user = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "User [id=" + id_user + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	
	
	
	

}
