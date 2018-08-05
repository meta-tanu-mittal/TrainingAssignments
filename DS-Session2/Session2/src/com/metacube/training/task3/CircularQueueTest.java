package com.metacube.training.task3;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {

	@Test
	public void testIsEmpty() {
		CircularQueue queue=new CircularQueue(3);
		assertEquals(true,queue.isEmpty());
	}
	
	@Test
	public void testIsFull() {
		CircularQueue queue=new CircularQueue(3);
		queue.addItem(3);
		queue.addItem(4);
		queue.addItem(5);
		assertEquals(true,queue.isFull());
	}
	
	@Test
	public void testRemoveItem() {
		CircularQueue queue=new CircularQueue(3);
		queue.addItem(3);
		queue.addItem(4);
		queue.addItem(5);
		assertEquals(3,queue.removeItem());
	}

}
