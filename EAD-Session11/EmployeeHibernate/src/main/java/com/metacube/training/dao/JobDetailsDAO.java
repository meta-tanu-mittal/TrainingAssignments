package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.JobDetails;

public interface JobDetailsDAO {

	
	public boolean insertJobDetails(JobDetails jobDetails);

	
	public boolean updateJobDetails(JobDetails jobDetails);

	
	public JobDetails getJobDetailsById(int jobDetailId);

	
	public List<JobDetails> getAllJobDetails();


}
