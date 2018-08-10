package com.metacube.training.priorityQueue.task2;

import static org.junit.Assert.*;

import org.junit.Test;



public class PriorityQueueTest {

	@Test
	public void test() {
		PriorityQueue queue=new PriorityQueue(3);
		assertEquals(true,queue.isEmpty());
	}
	
	@Test
	public void testIsFull() {
		PriorityQueue queue=new PriorityQueue(3);
		queue.addItem(new Data(5,3));
		queue.addItem(new Data(7,7));
		queue.addItem(new Data(4,5));
		assertEquals(true,queue.isFull());
	}
	
	@Test
	public void testAddItem() {
		PriorityQueue queue=new PriorityQueue(3);
		queue.addItem(new Data(5,3));
		queue.addItem(new Data(1,7));
		queue.addItem(new Data(4,5));
		assertEquals(1,queue.removeItem().getValue());
	}
	
	@Test
	public void testRemoveItem() {
		PriorityQueue queue1=new PriorityQueue(3);
		queue1.addItem(new Data(5,3));
		queue1.addItem(new Data(1,7));
		queue1.addItem(new Data(4,5));
		assertEquals(1,queue1.removeItem().getValue());
		assertEquals(4,queue1.removeItem().getValue());
		assertEquals(5,queue1.removeItem().getValue());
	}


}
