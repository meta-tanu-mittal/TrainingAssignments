package com.metacube.training.employee.task1;

import java.util.Comparator;

/**
 * In this employees are sort according to their id
 * 
 * @author Tanu Mittal
 *
 */
public class NaturalOrderSorting implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {

		return (emp1.getId() - emp2.getId());
	}

}
