package com.metacube.training.task2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomialJUnitTest {
	Polynomial polynomial1 = new Polynomial(new int[][] { { 2, 2 }, { 3, 1 }, { 5, 0 } });
	Polynomial polynomial2 = new Polynomial(new int[][] { { 4, 1 }, { 2, 0 } });

	@Test
	public void testEvaluate() {
		Polynomial polynomial = new Polynomial(new int[][] { { 2, 2 }, { 3, 1 }, { 5, 0 } });
		double value = polynomial.evaluate(2);
		assertEquals(19, value, 0.001);

	}

	@Test
	public void testDegree() {
		int highestDegree = polynomial1.degree();
		assertEquals(2, highestDegree);

	}

}
