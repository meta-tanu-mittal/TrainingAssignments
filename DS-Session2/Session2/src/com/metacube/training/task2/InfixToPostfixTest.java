package com.metacube.training.task2;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {

	@Test
	public void test() {
		InfixToPostfix obj=new InfixToPostfix();
		String result=obj.convertInfixToPostfix("a + b");
		assertEquals("ab+",result);
	}

	
	@Test
	public void test1() {
		InfixToPostfix obj=new InfixToPostfix();
		String result=obj.convertInfixToPostfix("( a + b ) * ( c + d )");
		assertEquals("ab+cd+*",result);
	}

}
