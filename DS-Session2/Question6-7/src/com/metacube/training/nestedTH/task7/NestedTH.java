package com.metacube.training.nestedTH.task7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * find value in nested list according to its position if present
 * 
 * @author Tanu Mittal
 *
 */
public class NestedTH {
	private List<Object> nestedList;

	/**
	 * parametrized constructor
	 * 
	 * @param nestedList
	 *            is a list of object
	 */
	public NestedTH(List<Object> nestedList) {
		this.nestedList = nestedList;
	}

	/**
	 * get integer value at given position if present
	 * 
	 * @param input
	 *            is a input string
	 * @return value at given position
	 */
	public int getValue(String input) {
		int value = getValueAtPosition(input, nestedList);
		return value;
	}

	/**
	 * helper method to find value at given position
	 * 
	 * @param input
	 *            is a input string
	 * @param list
	 *            is nested list of integers
	 * @return value at given position
	 */
	private int getValueAtPosition(String input, List<Object> list) {
		int value = 0;
		if (input.charAt(0) != 'T' && input.charAt(0) != 'H') {
			throw new AssertionError("string can only contain T and H ");
		}

		if (input.length() == 1) {
			if (input.charAt(0) == 'T') {
				throw new AssertionError("input string not correct");
			} else {
				if (input.charAt(0) == 'H') {
					if (list.get(0) instanceof Integer) {
						value = (int) list.get(0);
						return value;
					} else {
						throw new AssertionError(
								"integer is not present at given position");
					}
				}
			}
		}

		if (input.length() > 1) {
			if (input.charAt(0) == 'T') {
				if (list.size() > 1) {
					list.remove(0);
					value = getValueAtPosition(input.substring(1), list);
				}

			} else {
				if (input.charAt(0) == 'H') {
					value = getValueAtPosition(input.substring(1),
							(List<Object>) list.get(0));
				}
			}
		}
		return value;
	}

}
