package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.EmployeeSkill;
import com.metacube.training.model.Project;
import com.metacube.training.repository.EmployeeSkillRepository;
import com.metacube.training.repository.ProjectRepository;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService{
    
	@Autowired
	private EmployeeSkillRepository employeeSkillRepository;
	
	@Override
	public boolean insertEmployeeSkill(EmployeeSkill employeeSkill) {
		try
		{
			employeeSkillRepository.save(employeeSkill);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
		
	}

	@Override
	@Transactional
	public List<Integer> getAllEmployeeCode(int skillCode) {
		return employeeSkillRepository.getAllEmployeeCode();
	}

}
