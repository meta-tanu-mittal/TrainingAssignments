package com.metacube.training.commonFactors;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommonFactorsJunitTestCase {

	@Test
	public void test() {
		CommonFactors commonFactors = new CommonFactors();
		assertEquals(5, commonFactors.findHCF(5, 30));

	}

	@Test
	public void test1() {
		CommonFactors commonFactors = new CommonFactors();
		assertEquals(30, commonFactors.findLCM(5, 30));

	}
}
