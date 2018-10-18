package com.metacube.training.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "job_details")
public class JobDetails {

	@Id
	@Column(name = "job_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobDetailId;
	
	@Column(name="emp_code")
	private int empCode;
	
	@Column(name="date_of_joining")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;
	
	@Column(name="total_exp")
	private int totalExperience;
	
	@Column(name="job_code")
	private int jobCode;
	
	@Column(name="reporting_mgr")
	private int reportingManagerId;
	
	@Column(name="team_lead")
	private int teamLeadId;
	
	@Column(name="curr_proj_id")
	private int currProjId;

	/**
	 * @return the empCode
	 */
	public int getEmpCode() {
		return empCode;
	}

	/**
	 * @param empCode
	 *            the empCode to set
	 */
	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	/**
	 * @return the jobDetailId
	 */
	public int getJobDetailId() {
		return jobDetailId;
	}

	/**
	 * @param jobDetailId
	 *            the jobDetailId to set
	 */
	public void setJobDetailId(int jobDetailId) {
		this.jobDetailId = jobDetailId;
	}

	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining
	 *            the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the totalExp
	 */
	public int getTotalExperience() {
		return totalExperience;
	}

	/**
	 * @param totalExp
	 *            the totalExp to set
	 */
	public void setTotalExp(int totalExperience) {
		this.totalExperience = totalExperience;
	}

	/**
	 * @return the jobCode
	 */
	public int getJobCode() {
		return jobCode;
	}

	/**
	 * @param jobCode
	 *            the jobCode to set
	 */
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}

	/**
	 * @return the reportingManager
	 */
	public int getReportingManagerId() {
		return reportingManagerId;
	}

	/**
	 * @param reportingManager
	 *            the reportingManager to set
	 */
	public void setReportingManagerId(int reportingManagerId) {
		this.reportingManagerId = reportingManagerId;
	}



	/**
	 * @return the currProjId
	 */
	public int getCurrProjId() {
		return currProjId;
	}

	/**
	 * @param currProjId
	 *            the currProjId to set
	 */
	public void setCurrProjId(int currProjId) {
		this.currProjId = currProjId;
	}

	@Override
	public String toString() {
		return "JobDetails [jobDetailId=" + jobDetailId + ", empCode="
				+ empCode + ", dateOfJoining=" + dateOfJoining + ", totalExp="
				+ totalExperience + ", jobCode=" + jobCode + ", reportingManagerId="
				+ reportingManagerId + ", teamLeadId=" + teamLeadId
				+ ", currProjId=" + currProjId + "]";
	}

	public int getTeamLeadId() {
		return teamLeadId;
	}

	public void setTeamLeadId(int teamLeadId) {
		this.teamLeadId = teamLeadId;
	}

	
}
