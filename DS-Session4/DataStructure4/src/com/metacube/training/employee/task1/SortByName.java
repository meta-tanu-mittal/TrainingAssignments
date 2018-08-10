package com.metacube.training.employee.task1;

import java.util.Comparator;

/**
 * In this employees are sorted according to their name
 * 
 * @author Tanu Mittal
 *
 */
public class SortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return (emp1.getName().compareToIgnoreCase(emp2.getName()));
	}

}
