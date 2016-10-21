package com.mock.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	
	@ManyToMany(targetEntity=University.class)
	@JsonManagedReference
	@JsonIgnore
//	@JsonProperty(access = Access.READ_ONLY)
	private List<University> favouriteUniversities;
	
	public User() {}

	public User(String username, String password, String firstName, String lastName) {
		super();
	
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.favouriteUniversities = new ArrayList<University>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
//	public List<University> getFavouriteUniversities() {
//		return this.favouriteUniversities;
//	}
//	
//	public void addFavouriteUniversity(University university) {
//		this.favouriteUniversities.add(university);
//		university.getUsers().add(this);
//	}
	
	

}
