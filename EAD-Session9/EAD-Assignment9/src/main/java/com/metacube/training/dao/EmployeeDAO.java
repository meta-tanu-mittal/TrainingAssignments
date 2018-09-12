package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeDAO {

	/**
	 * insert employee details
	 * @param employee  is employee details to be added
	 * @return true if employee is inserted
	 */
	public boolean insertEmployee(Employee employee);

	/**
	 * update employee details
	 * @param employee
	 * @return true if details are updated
	 */
	public boolean updateEmployee(Employee employee);

	/**
	 * find employee by id
	 * @param empCode is id of employee
	 * @return employee details corresponding to id
	 */
	public Employee getEmployeeById(int empCode);

	/**
	 * find list of all employee
	 * @return list of employee
	 */
	public List<Employee> getAllEmployee();

	/**
	 * check login validity
	 * @param emailId
	 * @param password
	 * @return employee details corresponding to email id and password
	 */
	public Employee checkValidLogin(String emailId, String password);

}
