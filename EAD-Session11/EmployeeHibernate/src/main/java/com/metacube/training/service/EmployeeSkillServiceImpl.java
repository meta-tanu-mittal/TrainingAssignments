package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeSkillDAO;
import com.metacube.training.model.EmployeeSkill;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService{
    
	@Autowired
	private EmployeeSkillDAO employeeSkillDAO;
	
	@Override
	public boolean insertEmployeeSkill(EmployeeSkill employeeSkill) {
		return employeeSkillDAO.insertEmployeeSkill(employeeSkill);
	}

	@Override
	public List<Integer> getAllEmployeeCode(int skillCode) {
		return employeeSkillDAO.getAllEmployeeCode(skillCode);
	}

}
