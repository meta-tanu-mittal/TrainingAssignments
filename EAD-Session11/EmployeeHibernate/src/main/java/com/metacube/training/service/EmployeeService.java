package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeService {
	public boolean insertEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	public Employee getEmployeeById(int empCode);

	public List<Employee> getAllEmployee();

	public Employee checkValidLogin(String emailId, String password);

}
