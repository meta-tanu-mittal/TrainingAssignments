package com.metacube.training.task4;

/**
 * @author Tanu Mittal
 *
 */
public class CollegeProgram {
	private String programName;
	private int capacity;

	/**
	 * parametrized constructor
	 * 
	 * @param programName
	 *            is name of program in college
	 * @param capacity
	 *            is number of seats in program
	 */
	public CollegeProgram(String programName, int capacity) {
		this.programName = programName;
		this.capacity = capacity;
	}

	/**
	 * @return program name
	 */
	String getProgramName() {
		return programName;
	}

	/**
	 * @return capacity of program
	 */
	int getCapacity() {
		return capacity;
	}

	/**
	 * set capacity of program
	 * 
	 * @param capacity
	 *            is capacity of program
	 */
	void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
