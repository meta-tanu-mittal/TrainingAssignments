package com.metacube.training.nestedJSON.task6;

/**
 * Nested List Interface
 * 
 * @author Tanu Mittal
 *
 */
public interface INestedList {
	/**
	 * find sum of integer values in nested list
	 * 
	 * @return sum
	 */
	public int sum();

	/**
	 * find largest value from nested list
	 * 
	 * @return largest value
	 */
	public int largestValue();

	/**
	 * check whether a integer value is present or not
	 * 
	 * @param value
	 *            is the value to be checkes
	 * @return true if value is present in lists
	 */
	public boolean search(int value);

}
