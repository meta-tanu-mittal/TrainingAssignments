package com.metacube.training.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {

	private int empCode;
	private String firstName;
	private String lastName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String gender;
	private String primaryContactNo;
	private String secondaryContactNo;
	private String emailId;
	private String skypeId;
	private String profilePicture;
	private String password;
	private boolean isActive;

	public Employee() {

	}
	
	

	public Employee(int empCode, String firstName, String lastName, Date dob, String gender,
			String primaryContactNo, String secondaryContactNo, String emailId, String skypeId) {
		this.empCode = empCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.primaryContactNo = primaryContactNo;
		this.secondaryContactNo = secondaryContactNo;
		this.emailId = emailId;
		this.skypeId = skypeId;
	}


	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
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

	public java.util.Date getDob() {
		return dob;
	}

	public void setDob(Date date) {
		this.dob = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPrimaryContactNo() {
		return primaryContactNo;
	}

	public void setPrimaryContactNo(String primaryContactNo) {
		this.primaryContactNo = primaryContactNo;
	}

	public String getSecondaryContactNo() {
		return secondaryContactNo;
	}

	public void setSecondaryContactNo(String secondaryContactNo) {
		this.secondaryContactNo = secondaryContactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}