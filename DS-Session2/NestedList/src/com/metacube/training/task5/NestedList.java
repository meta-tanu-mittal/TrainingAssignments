package com.metacube.training.task5;

import java.util.ArrayList;
import java.util.List;

/**
 * following operations are performed on nested list 1 sum 2 find largest value
 * 3 search element
 * 
 * @author Tanu Mittal
 *
 */
public class NestedList implements INestedList {
	private List<List<Integer>> nestedList;

	/**
	 * default constructor
	 */
	public NestedList() {

	}

	/**
	 * parametrised constructor
	 * 
	 * @param nestedList
	 *            is a nested list
	 */
	public NestedList(List<List<Integer>> nestedList) {
		this.nestedList = nestedList;
	}

	@Override
	public int sum() {

		if (nestedList.size() == 0) {
			throw new AssertionError("list is empty");
		}
		int sum = 0;
		for (int i = 0; i < nestedList.size(); i++) {
			for (int j = 0; j < nestedList.get(i).size(); j++) {
				sum += nestedList.get(i).get(j);
			}
		}
		return sum;
	}

	@Override
	public int largestValue() {
		int max = nestedList.get(0).get(1);
		for (int i = 0; i < nestedList.size(); i++) {
			for (int j = 0; j < nestedList.get(i).size(); j++) {
				if (nestedList.get(i).get(j) > max) {
					max = nestedList.get(i).get(j);
				}
			}
		}
		return max;
	}

	@Override
	public boolean search(int value) {

		for (int i = 0; i < nestedList.size(); i++) {
			for (int j = 0; j < nestedList.get(i).size(); j++) {
				if (nestedList.get(i).get(j) == value) {
					return true;
				}
			}
		}
		return false;
	}

}
