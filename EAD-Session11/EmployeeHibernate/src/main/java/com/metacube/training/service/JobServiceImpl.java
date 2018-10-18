package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.JobDAO;
import com.metacube.training.model.Job;

@Service
public class JobServiceImpl implements JobService{
	
    @Autowired
	JobDAO jobDAO;
    
	@Override
	public Job getJobTitleById(int id) {
		return jobDAO.getJobTitleById(id);
	}

	@Override
	public List<Job> getAllJobTitle() {
		return jobDAO.getAllJobTitle();
	}

	@Override
	public boolean updateJobTitle(Job jobTitle) {
		return jobDAO.updateJobTitle(jobTitle);
	}

	@Override
	public boolean insertJobTitle(Job jobTitle) {
		return jobDAO.insertJobTitle(jobTitle);
	}

}
