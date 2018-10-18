package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRoles {

@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "email_id")
private String emailId;

@Column(name = "role")
private String role;

public UserRoles()
{
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}



}