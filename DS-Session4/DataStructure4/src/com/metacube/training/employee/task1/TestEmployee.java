package com.metacube.training.employee.task1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestEmployee {

	@Test
	public void testNaturalOrderSorting() {
		EmployeeCollection obj = new EmployeeCollection();
		assertTrue(obj.addEmployee(new Employee(1, "tanu", "address1")));
		assertTrue(obj.addEmployee(new Employee(25, "richa", "address2")));
		assertTrue(obj.addEmployee(new Employee(12, "namrata", "address3")));
		assertFalse(obj.addEmployee(new Employee(1, "tanu", "address4")));
		Collections.sort(obj.getEmployeeList(), new NaturalOrderSorting());
		List<Employee> expected = new ArrayList<Employee>() {
			{
				add(new Employee(1, "tanu", "address1"));
				add(new Employee(12, "namrata", "address3"));
				add(new Employee(25, "richa", "address2"));
			}
		};

		List<Employee> result = obj.getEmployeeList();
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expected.get(i).getId(), result.get(i).getId());
			assertEquals(expected.get(i).getName(), result.get(i).getName());
		}
	}

	public void sortByName() {
		EmployeeCollection obj = new EmployeeCollection();
		assertTrue(obj.addEmployee(new Employee(1, "tanu", "address1")));
		assertTrue(obj.addEmployee(new Employee(25, "richa", "address2")));
		assertTrue(obj.addEmployee(new Employee(12, "namrata", "address3")));
		assertFalse(obj.addEmployee(new Employee(1, "tanu", "address4")));
		Collections.sort(obj.getEmployeeList(), new SortByName());
		List<Employee> expected = new ArrayList<Employee>() {
			{
				add(new Employee(12, "namrata", "address3"));
				add(new Employee(25, "richa", "address2"));
				add(new Employee(1, "tanu", "address1"));
			}
		};

		List<Employee> result = obj.getEmployeeList();
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expected.get(i).getId(), result.get(i).getId());
			assertEquals(expected.get(i).getName(), result.get(i).getName());
		}
	}

}
