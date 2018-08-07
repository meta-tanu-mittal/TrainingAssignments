package com.metacube.training.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main Class
 * @author Tanu Mittal
 *
 */
public class NestedMain {
	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();

	    List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(3, 4, 6));
	    List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
	    List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(2, 3, 6));
	    List<Integer> list4 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
	    List<Integer> list5 = new ArrayList<Integer>(Arrays.asList(4, 8, 13));

	    lists.add(list1);
	    lists.add(list2);
	    lists.add(list3);
	    lists.add(list4);
	    lists.add(list5);
	    NestedList nestedList=new NestedList(lists);
	    System.out.println("sum of elements are:"+nestedList.sum());
	    System.out.println("largest value is:"+nestedList.largestValue());
	}

}
