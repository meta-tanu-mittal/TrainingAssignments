package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobDAO {
	
	Job getJobTitleById(int id);

	List<Job> getAllJobTitle();

	boolean updateJobTitle(Job jobTitle);

	boolean insertJobTitle(Job jobTitle);

}
