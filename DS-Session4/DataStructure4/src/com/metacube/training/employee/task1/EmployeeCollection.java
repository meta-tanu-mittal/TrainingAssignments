package com.metacube.training.employee.task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 
 * @author user
 *
 */
public class EmployeeCollection {
	private List<Employee> listOfEmployee;
	private Set<Integer> setOfId;
  
	/**
	 * default constructor
	 */
	public EmployeeCollection() {
		listOfEmployee = new ArrayList<Employee>();
		setOfId = new HashSet<Integer>();
	}

	/**
	 * add employee in list
	 * @param employee is employee to be added to list
	 * @return true if employee is added
	 */
	public boolean addEmployee(Employee employee) {
		boolean status = setOfId.add(employee.getId());
		if (status) {
			listOfEmployee.add(employee);
			return true;
		}
		return false;
	}
    
	/**
	 * @return list of employee
	 */
	public List<Employee> getEmployeeList() {
		return listOfEmployee;
	}
   
	/**
	 * display list of employee
	 */
	public void display() {
		for (Employee employee : listOfEmployee) {
			System.out.println(employee.getId() + " " + employee.getName()
					+ " " + employee.getAddress());
		}
	}

	

}
