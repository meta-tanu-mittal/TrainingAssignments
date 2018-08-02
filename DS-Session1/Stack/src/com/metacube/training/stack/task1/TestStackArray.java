package com.metacube.training.stack.task1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestStackArray {

	@Test
	public void testPush() {
		StackUsingArray obj = new StackUsingArray(3);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		Integer[] expected = { 3, 4, 5 };
		assertArrayEquals(expected, obj.getObjectList());
	}

	@Test(expected = AssertionError.class)
	public void testPushNegative() {
		StackUsingArray obj = new StackUsingArray(3);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.push(6);
	}

	@Test
	public void testPop() {
		StackUsingArray obj = new StackUsingArray(3);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		assertEquals(5, obj.pop());
	}

}
