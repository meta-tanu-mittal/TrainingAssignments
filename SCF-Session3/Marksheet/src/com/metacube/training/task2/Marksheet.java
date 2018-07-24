package com.metacube.training.task2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Marks of student 1 Average marks 2 maximum marks 3 minimum marks 4 percentage
 * of student passed
 * 
 * @author Tanu Mittal
 *
 */
public class Marksheet {
	ArrayList<Double> lst = new ArrayList<Double>();
	// int noOfStudents;
	Scanner sc = new Scanner(System.in);


	/**
	 * Constructor of class
	 */
	public Marksheet() {
		System.out.print("enter the number of students: ");
		int n = 0;
		try {
			n = sc.nextInt();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < n; i++) {
			System.out.print("entermarks of " + (i + 1) + " student:");
			lst.add(sc.nextDouble());
		}

	}

	/**
	 * find the average marks of all students
	 * 
	 * @return average marks
	 */
	public double averageMarks() throws ArithmeticException {
		double average = 0;
		for (int i = 0; i < lst.size(); i++) {
			average += lst.get(i);
		}
		return (average / lst.size());
	}

	/**
	 * find the maximum marks from list of student
	 * 
	 * @return maximum marks
	 */
	public double maximum() throws ArithmeticException {
		double max = 0;
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i) > max) {
				max = lst.get(i);
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
		double min = lst.get(0);
		for (int i = 1; i < lst.size(); i++) {
			if (lst.get(i) < min) {
				min = lst.get(i);
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
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i) >= 40) {
				count++;
			}
		}
		percent = ((double) (count * 100.0)) / lst.size();
		return percent;

	}

	/**
	 * display marks of all students
	 */
	public void display() throws ArithmeticException {
		for (int i = 0; i < lst.size(); i++) {
			System.out.println("student " + (i + 1) + ":" + lst.get(i));
		}
	}
}
