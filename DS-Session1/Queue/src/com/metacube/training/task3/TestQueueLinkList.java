package com.metacube.training.task3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQueueLinkList {

	@Test
	public void testAddItem() {
		QueueUsingLinkList obj = new QueueUsingLinkList();
		obj.addItem(3);
		obj.addItem(4);
		obj.addItem(5);
		Integer[] expected = { 3, 4, 5 };
		assertArrayEquals(expected, obj.getObjectList());
	}

	@Test
	public void testPop() {
		QueueUsingLinkList obj = new QueueUsingLinkList();
		obj.addItem(3);
		obj.addItem(4);
		obj.addItem(5);
		assertEquals(3, obj.pop());
	}

	@Test
	public void testIsEmpty() {
		QueueUsingLinkList obj = new QueueUsingLinkList();
		assertEquals(true, obj.isEmpty());
	}
}
