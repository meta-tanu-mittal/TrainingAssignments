package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public boolean insertEmployee(Employee employee) {
		try {
			employeeRepository.save(employee);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		try {
			employeeRepository.save(employee);
		} catch (Exception e) {
			return false;
		}
		return true;
		
	}

	@Override
	public Employee getEmployeeById(int empCode) {
		return employeeRepository.findOne(empCode);
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
		
	}

	@Override
	@Transactional
	public Employee checkValidLogin(String emailId, String password) {
		return employeeRepository.getEmployeeByEmailId(emailId, password);
	
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		return null;
		
	}

	@Override
	public Employee getEmployeeByEmailId(String emailId) {
		return null;
		
	}

}
