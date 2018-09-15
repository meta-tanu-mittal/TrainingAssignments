package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.EmployeeSkill;

public interface EmployeeSkillDAO {
	public boolean insertEmployeeSkill(EmployeeSkill employeeSkill);
	
	public List<Integer> getAllEmployeeCode(int skillCode);

}
