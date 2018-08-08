package com.metacube.training.priorityQueue.task2;

/**
 * 
 * @author Tanu
 *
 */
public class Data {
	private int value;
	private int priority;

	/**
	 * default constructor
	 */
	public Data() {

	}

	/**
	 * constructor
	 * 
	 * @param value
	 *            is any value
	 * @param priority
	 *            is priority of that value
	 */
	public Data(int value, int priority) {
		this.value = value;
		this.priority = priority;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
