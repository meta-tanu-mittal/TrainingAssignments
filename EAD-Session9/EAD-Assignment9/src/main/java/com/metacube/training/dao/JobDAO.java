package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobDAO {
  
	/**
	 * find job title by id
	 * @param id is id of job 
	 * @return job 
	 */
	Job getJobTitleById(int id);

	/**
	 * find all job title
	 * @return list of all job title
	 */
	List<Job> getAllJobTitle();

	/**
	 * update job title details
	 * @param jobTitle
	 * @return true if job title is updated
	 */
	boolean updateJobTitle(Job jobTitle);

	/**
	 * insert job title
	 * @param jobTitle
	 * @return true if job title is inserted
	 */
	boolean insertJobTitle(Job jobTitle);

}
