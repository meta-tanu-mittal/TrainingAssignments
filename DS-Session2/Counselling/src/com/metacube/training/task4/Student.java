package com.metacube.training.task4;

/**
 * 
 * @author Tanu Mittal
 *
 */
public class Student {
	private String name;
	private String[] choices;

	/**
	 * parametrized constructor
	 * 
	 * @param name
	 *            is name of choices
	 * @param choices
	 *            is choices of courses by student in order
	 */
	public Student(String name, String[] choices) {
		this.name = name;
		this.choices = choices;
	}

	/**
	 * @return name of student
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return order of choices made by student
	 */
	public String[] getListOfChoices() {
		return choices;
	}

}
