package com.metacube.training.stack.task1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStackLinkList {

	@Test
	public void testPush() {
		StackUsingLinkList obj = new StackUsingLinkList();
		obj.push(3);
		obj.push(4);
		obj.push(5);
		Integer[] expected = { 5, 4, 3 };
		assertArrayEquals(expected, obj.getObjectList());
	}

	@Test
	public void testPop() {
		StackUsingLinkList obj = new StackUsingLinkList();
		obj.push(3);
		obj.push(4);
		obj.push(5);
		assertEquals(5, obj.pop());
	}

}
