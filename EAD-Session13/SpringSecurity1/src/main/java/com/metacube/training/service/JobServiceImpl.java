package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Job;
import com.metacube.training.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
   private JobRepository jobRepository;
    
	@Override
	public Job getJobTitleById(int id) {
		return jobRepository.findOne(id);
	
	}

	@Override
	public List<Job> getAllJobTitle() {
		return jobRepository.findAll();
	
	}

	@Override
	public boolean updateJobTitle(Job jobTitle) {
		try
		{
			jobRepository.save(jobTitle);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	
	}

	@Override
	public boolean insertJobTitle(Job jobTitle) {
		try
		{
			jobRepository.save(jobTitle);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	
	
	}

}
