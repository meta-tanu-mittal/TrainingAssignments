package com.metacube.training.fcfs;

import static org.junit.Assert.*;

import org.junit.Test;

public class FCFSJUnitTest {
	Schedular obj=new Schedular(new int[][]{{0,5},{3,9},{6,6}});

	@Test
	public void testCompletionTime() {
		assertArrayEquals(new int[]{5,14,20},obj.completionTime());
	}
	
	@Test
	public void testWaitingTime() {
		assertArrayEquals(new int[]{0,2,8},obj.waitingTime());
	}

	@Test
	public void testTurnAroundTime() {
		assertArrayEquals(new int[]{5,11,14},obj.turnAroundTime());
	}
	
	@Test
	public void testMaximumWaitingTime() {
		assertEquals(8,obj.maximumWaitingTime());
	}
	
	@Test
	public void testAverageWaitingTime() {
		assertEquals(3.333,obj.averageWaitingTime(),0.001);
	}
}
