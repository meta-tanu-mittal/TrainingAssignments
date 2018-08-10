package com.metacube.training.employee.task1;

import java.util.Collections;

/**
 * Main class
 * 
 * @author Tanu Mittal
 *
 */
public class EmployeeMain {
	public static void main(String[] args) {

		EmployeeCollection obj = new EmployeeCollection();
		System.out.println(obj.addEmployee(new Employee(1, "tanu", "p1")));
		obj.addEmployee(new Employee(25, "richa", "p2"));
		obj.addEmployee(new Employee(12, "namrata", "p3"));
		obj.addEmployee(new Employee(1, "tanu", "p4s"));
		Collections.sort(obj.getEmployeeList(), new NaturalOrderSorting());
		System.out.println("employees sorted according to id");
		obj.display();
		Collections.sort(obj.getEmployeeList(), new SortByName());
		System.out.println("employees sorted according to name");
		obj.display();

	}

}
