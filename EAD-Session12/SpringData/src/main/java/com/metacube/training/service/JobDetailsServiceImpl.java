package com.metacube.training.service;

import groovy.transform.AnnotationCollector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.JobDetails;
import com.metacube.training.model.Project;
import com.metacube.training.repository.JobDetailsRepository;
import com.metacube.training.repository.ProjectRepository;

@Service
public class JobDetailsServiceImpl implements JobDetailsService {

	@Autowired
	private JobDetailsRepository jobDetailsRepository;
	
	@Override
	public boolean insertJobDetails(JobDetails jobDetails) {
		try
		{
			jobDetailsRepository.save(jobDetails);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
		
	}

	@Override
	public boolean updateJobDetails(JobDetails jobDetails) {
		return false;
	}

	@Override
	public JobDetails getJobDetailsById(int jobDetailId) {
		return jobDetailsRepository.findOne(jobDetailId);
	
	}

	@Override
	public List<JobDetails> getAllJobDetails() {
		return jobDetailsRepository.findAll();
	}

}
