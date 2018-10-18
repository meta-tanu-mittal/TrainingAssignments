package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.EmployeeSkill;

public interface EmployeeSkillService {
	public boolean insertEmployeeSkill(EmployeeSkill employeeSkill);

	public List<Integer> getAllEmployeeCode(int skillCode);
}
