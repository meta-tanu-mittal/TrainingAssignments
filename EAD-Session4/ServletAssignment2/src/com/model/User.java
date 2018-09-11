package com.model;

import java.util.Date;


public class User {
	private String id;
	private String firstName;
	private String lastName;
	private Date dob;
	private String contact;
	private String email;
	private String password;
	private String organization;
	private String image;
	
	public User(String firstName,String lastName,Date dob,String contact,String email,String password,String organization)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.dob=dob;
		this.contact=contact;
		this.email=email;
		this.password=password;
		this.organization=organization;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
