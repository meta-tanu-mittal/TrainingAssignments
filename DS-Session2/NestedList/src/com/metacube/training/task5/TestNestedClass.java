package com.metacube.training.task5;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestNestedClass {

	List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(2, 4, 6));
	List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
	List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(10, 5));
	List<List<Integer>> nestedList = new ArrayList<List<Integer>>() {
		{
			add(list1);
			add(list2);
			add(list3);
		}
	};
	NestedList nestedListObject = new NestedList(nestedList);

	@Test
	public void testSum() {
		assertEquals(33, nestedListObject.sum());
	}

	@Test
	public void testLargestValue() {
		assertEquals(10, nestedListObject.largestValue());
	}

	@Test
	public void testSearchElement() {
		assertEquals(true, nestedListObject.search(3));
	}

}
