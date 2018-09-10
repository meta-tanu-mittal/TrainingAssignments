package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeDAO {

	public boolean createEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public Employee getEmployeeById(int empCode);
	public List<Employee> getAllEmployee();
	
}
