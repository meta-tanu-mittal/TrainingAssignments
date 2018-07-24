package com.metacube.training.search;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchJUnitTest {

	@Test
	public void test() {
		Search obj = new Search();
		int position = obj.linearSearch(new int[] { 2, 5, 4, 6, 9, 7 }, 4);
		assertEquals(3, position + 1);
	}

	@Test
	public void test1() {
		Search obj = new Search();
		int searchArray[] = new int[] { 2, 4, 6, 7, 8, 9, 10 };
		int position = obj.binarySearch(searchArray, 9, 0, searchArray.length);
		assertEquals(6, position + 1);
	}

}
