package com.metacube.training.task4;

/**
 * 
 * @author Tanu Mittal
 *
 */
public class AllocatedProgram {
	private String nameOfStudent;
	private String program;

	/**
	 * parametrized constructor
	 * 
	 * @param name
	 *            is name of student
	 * @param program
	 *            is program allocated to student
	 */
	public AllocatedProgram(String nameOfStudent, String program) {
		this.nameOfStudent = nameOfStudent;
		this.program = program;
	}

	/**
	 * @return name of student
	 */
	public String getName() {
		return nameOfStudent;
	}

	/**
	 * @param nameOfStudent
	 */
	public void setName(String nameOfStudent) {
		this.nameOfStudent = nameOfStudent;
	}

	/**
	 * @return program name
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * @param program
	 *            is program name
	 */
	public void setProgram(String program) {
		this.program = program;
	}

}
