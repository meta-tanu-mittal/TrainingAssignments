package com.metacube.training.hexadecimal;

import static org.junit.Assert.*;

import org.junit.Test;

public class HexJunitTest {
	HexCalc number1=new HexCalc("4A6");
	HexCalc number2=new HexCalc("1B3");

	@Test
	public void testAddition() {
		assertEquals("659",number1.add(number2));
	}
	
	@Test
	public void testSubtraction() {
		assertEquals("2F3",number1.subtract(number2));
	}
	
	@Test
	public void testMultiplication() {
		assertEquals("7E612",number1.multiply(number2));
	}
	
	@Test
	public void testDivison() {
		assertEquals("2",number1.divide(number2));
	}

	
	@Test
	public void testConvertHexToDecimal() {
		assertEquals(1190,number1.convertHexToDecimal());
	}
	
	@Test
	public void testIsGreaterThan() {
		assertEquals(true,number1.greaterThan(number2));
	}
	
	@Test
	public void testIsLessThan() {
		assertEquals(false,number1.lessThan(number2));
	}

	
	public void testIsEqual() {
		assertEquals(false,number1.equals(number2));
	}

}
