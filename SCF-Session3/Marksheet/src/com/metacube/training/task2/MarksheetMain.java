package com.metacube.training.task2;

import java.text.DecimalFormat;

public class MarksheetMain {

	public static void main(String[] args) {
		Marksheet obj = new Marksheet();
		obj.display();
		DecimalFormat df = new DecimalFormat("####0.00");
		System.out.println("averageMarks:" + df.format(obj.averageMarks()));
		System.out.println("maximum marks:" + obj.maximum());
		System.out.println("minimum marks" + obj.minimum());
		System.out.println("number of students passed:" + df.format(obj.percentOfStudentPassed()));
	}

}
