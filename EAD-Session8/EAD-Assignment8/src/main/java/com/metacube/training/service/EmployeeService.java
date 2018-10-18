package com.metacube.training.service;

import java.util.List;

import com.metacube.training.dao.EmployeeDAOImpl;
import com.metacube.training.model.Employee;

public class EmployeeService {
	
	public boolean insertEmployee(Employee employee)
	{  
		EmployeeDAOImpl obj=new EmployeeDAOImpl();
		return obj.insertEmployee(employee);
	}

	
	public List<Employee> getAllEmployee()
	{
		EmployeeDAOImpl obj=new EmployeeDAOImpl();
		return obj.getAllEmployee();
	}
	
	public Employee getEmployeeById(int empCode)
	{
		EmployeeDAOImpl obj=new EmployeeDAOImpl();
		return obj.getEmployeeById(empCode);
	}
}
