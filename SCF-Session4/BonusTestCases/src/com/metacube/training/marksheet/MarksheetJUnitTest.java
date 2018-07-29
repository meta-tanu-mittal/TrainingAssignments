package com.metacube.training.marksheet;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarksheetJUnitTest {
     Marksheet marksheet =new Marksheet(new double[]{10,20,30,40,50});
	@Test
	public void testAverageMarks() {
		assertEquals(30,marksheet.averageMarks(),0.001);
	}
	
	public void testMaximumMarks() {
		assertEquals(50,marksheet.maximum(),0.001);
	}
	
	public void testMinimumMarks() {
		assertEquals(10,marksheet.minimum(),0.001);
	}

	
	public void testPercentOfStudentPassed() {
		assertEquals(40,marksheet.percentOfStudentPassed(),0.001);
	}
}
