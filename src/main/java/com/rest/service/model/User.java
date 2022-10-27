package com.rest.service.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue
	private int id_user;
	
	@JsonProperty("user_name")
	@Size(min = 2, message = "Name should have at least 2 characters")
	private String name;
	
	@JsonProperty("birth_date")
	@Past(message = "Birthdate should be in the past")
	private LocalDate birthdate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
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
	
	

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id_user + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	
	
	
	

}
