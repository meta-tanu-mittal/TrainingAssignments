package com.metacube.training.marksheet;

/**
 * Marks of student 1 Average marks 2 maximum marks 3 minimum marks 4 percentage
 * of student passed
 * 
 * @author Tanu Mittal
 *
 */
public class Marksheet {
	double[] marks;
	int noOfStudents;

	/**
	 * constructor
	 * 
	 * @param marks
	 *            is an array of marks of all students
	 */
	public Marksheet(double[] marks) {
		noOfStudents = marks.length;
		this.marks = marks;

	}

	/**
	 * find the average marks of all students
	 * 
	 * @return average marks
	 */
	public double averageMarks() throws ArithmeticException {
		double totalMarks = 0;
		for (int i = 0; i < noOfStudents; i++) {
			totalMarks += marks[i];
		}
		return (totalMarks / noOfStudents);
	}

	/**
	 * find the maximum marks from list of student
	 * 
	 * @return maximum marks
	 */
	public double maximum() throws ArithmeticException {
		double max = 0;
		for (int i = 0; i < noOfStudents; i++) {
			if (marks[i] > max) {
				max = marks[i];
			}
		}
		return max;
	}

	/**
	 * find minimum marks from list of students
	 * 
	 * @return minimum marks
	 */
	public double minimum() throws ArithmeticException {
		double min = marks[0];
		for (int i = 1; i < noOfStudents; i++) {
			if (marks[i] < min) {
				min = marks[i];
			}
		}
		return min;
	}

	/**
	 * Find percentage of student passed
	 * 
	 * @return percent of student passed
	 */
	public double percentOfStudentPassed() throws ArithmeticException {
		double percent = 0;
		int count = 0;
		for (int i = 0; i < noOfStudents; i++) {
			if (marks[i] >= 40) {
				count++;
			}
		}
		percent = ((double) (count * 100.0)) / noOfStudents;
		return percent;

	}

	/**
	 * display marks of all students
	 */
	public void display() throws ArithmeticException {
		for (int i = 0; i < noOfStudents; i++) {
			System.out.println("student " + (i + 1) + ":" + marks[i]);
		}
	}
}
