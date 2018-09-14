package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public boolean insertEmployee(Employee employee) {
		return employeeDAO.insertEmployee(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(int empCode) {
		return employeeDAO.getEmployeeById(empCode);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}

	@Override
	public Employee checkValidLogin(String emailId, String password) {
		Employee employee = new Employee();
		try {
			employee = employeeDAO.checkValidLogin(emailId, password);

		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return employee;
	}

}
