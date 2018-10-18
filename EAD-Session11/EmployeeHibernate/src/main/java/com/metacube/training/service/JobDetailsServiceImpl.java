package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.JobDetailsDAO;
import com.metacube.training.model.JobDetails;

@Service
public class JobDetailsServiceImpl implements JobDetailsService {

	@Autowired
	private JobDetailsDAO jobDetailsDAO;
	
	@Override
	public boolean insertJobDetails(JobDetails jobDetails) {
		return jobDetailsDAO.insertJobDetails(jobDetails);
	}

	@Override
	public boolean updateJobDetails(JobDetails jobDetails) {
		return false;
	}

	@Override
	public JobDetails getJobDetailsById(int jobDetailId) {
		return jobDetailsDAO.getJobDetailsById(jobDetailId);
	}

	@Override
	public List<JobDetails> getAllJobDetails() {
		return null;
	}

}
