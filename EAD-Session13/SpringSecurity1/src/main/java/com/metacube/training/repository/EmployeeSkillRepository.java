package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.model.EmployeeSkill;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Integer>{

	@Query("select e.empCode from EmployeeSkill e ")
	public List<Integer> getAllEmployeeCode();
}
