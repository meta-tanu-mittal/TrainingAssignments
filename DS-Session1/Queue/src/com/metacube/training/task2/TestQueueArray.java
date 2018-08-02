package com.metacube.training.task2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.training.task3.QueueUsingLinkList;

public class TestQueueArray {

	@Test
	public void testAddItem() {
		QueueUsingArray obj = new QueueUsingArray(4);
		obj.addItem(3);
		obj.addItem(4);
		obj.addItem(5);
		Integer[] expected = { 3, 4, 5 };
		assertArrayEquals(expected, obj.getObjectList());
	}

	@Test
	public void testPop() {
		QueueUsingArray obj = new QueueUsingArray(4);
		obj.addItem(3);
		obj.addItem(4);
		obj.addItem(5);
		assertEquals(3, obj.removeItem());
	}

	@Test
	public void testIsEmpty() {
		QueueUsingArray obj = new QueueUsingArray(3);
		assertEquals(true, obj.isEmpty());
	}

	@Test
	public void testIsFull() {
		QueueUsingArray obj = new QueueUsingArray(3);
		obj.addItem(3);
		obj.addItem(4);
		obj.addItem(5);
		assertEquals(true, obj.isFull());
	}

}
