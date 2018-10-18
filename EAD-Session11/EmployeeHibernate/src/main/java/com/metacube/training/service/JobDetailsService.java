package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.JobDetails;

public interface JobDetailsService {
	public boolean insertJobDetails(JobDetails jobDetails);

	public boolean updateJobDetails(JobDetails jobDetails);

	public JobDetails getJobDetailsById(int jobDetailId);

	public List<JobDetails> getAllJobDetails();

}
