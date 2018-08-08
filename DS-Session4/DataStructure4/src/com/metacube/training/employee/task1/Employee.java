package com.metacube.training.employee.task1;

/**
 * Employee class
 * 
 * @author Tanu Mittal
 *
 */
public class Employee {
	private int id;
	private String name;
	private String address;

	/**
	 * constructor
	 * 
	 * @param id
	 *            is id of employee
	 * @param name
	 *            is name of employee
	 * @param address
	 *            is address of employee
	 */
	public Employee(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
