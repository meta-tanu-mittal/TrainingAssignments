package com.metacube.training.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employee")
public class Employee {
    
	@Id
	@Column(name = "emp_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empCode;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="primary_contact_no")
	private String primaryContactNo;
	
	@Column(name="secondary_contact_no")
	private String secondaryContactNo;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="skype_id")
	private String skypeId;
	
	@Column(name="profile_picture")
	private String profilePicture;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;

	public Employee() {

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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", gender=" + gender + ", primaryContactNo=" + primaryContactNo + ", secondaryContactNo="
				+ secondaryContactNo + ", emailId=" + emailId + ", skypeId=" + skypeId + ", profilePicture="
				+ profilePicture + ", password=" + password + ", enabled=" + enabled + "]";
	}

}