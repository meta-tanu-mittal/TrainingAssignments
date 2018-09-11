package com.metacube.training.nestedTH.task7;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NestedTHTest {

	@Test
	public void test() {
		List<Object> nestedList = new ArrayList<Object>();
		nestedList.add(1);
		nestedList.add(9);
		nestedList.add(new ArrayList<Integer>() {
			{
				add(3);
				add(4);
			}
		});
		nestedList.add(5);
		NestedTH obj = new NestedTH(nestedList);
		assertEquals(1, obj.getValue("H"));
	}

	@Test
	public void test1() {
		List<Object> nestedList = new ArrayList<Object>();
		nestedList.add(1);
		nestedList.add(9);
		nestedList.add(new ArrayList<Integer>() {
			{
				add(3);
				add(4);
			}
		});
		nestedList.add(5);
		NestedTH obj = new NestedTH(nestedList);
		assertEquals(9, obj.getValue("TH"));
	}

	@Test
	public void test2() {
		List<Object> nestedList = new ArrayList<Object>();
		nestedList.add(1);
		nestedList.add(9);
		nestedList.add(new ArrayList<Integer>() {
			{
				add(3);
				add(4);
			}
		});
		nestedList.add(5);
		NestedTH obj = new NestedTH(nestedList);
		assertEquals(3, obj.getValue("TTHH"));
	}

	@Test(expected = AssertionError.class)
	public void test3() {
		List<Object> nestedList = new ArrayList<Object>();
		nestedList.add(1);
		nestedList.add(9);
		nestedList.add(new ArrayList<Integer>() {
			{
				add(3);
				add(4);
			}
		});
		nestedList.add(5);
		NestedTH obj = new NestedTH(nestedList);
		obj.getValue("T");
	}

}
