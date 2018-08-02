package com.metacube.training.stringFunction;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringJUnitTest {
	StringMethod obj=new StringMethod();
	@Test
	public void testCompareString() {
		boolean b=obj.compareString("abc", "abc");
		assertEquals(true,b);
	}
	
	@Test
	public void testCaseConversion() {
		String str=obj.caseConversion("ab11GJ");
		assertEquals("AB11gj",str);
	}
	
	@Test
	public void testLargestWord() {
		String str=obj.largestWord("my name is tanu mittal");
		assertEquals("mittal",str);
	}
	
	
	}
