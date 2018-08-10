package com.metacube.training.task3;

/**
 * queue interface
 * 
 * @author Tanu Mittal
 *
 */
public interface QueueInterface {
	/**
	 * add item to queue
	 * 
	 * @param value
	 *            is item to be added to queue
	 */
	public void addItem(int value);

	/**
	 * remove item from queue
	 * 
	 * @return item that is removed from queue
	 */
	public int removeItem();

	/**
	 * check whether queue is empty or not
	 * 
	 * @return true if queue is empty
	 */
	boolean isEmpty();

	/**
	 * check whether queue is full or not
	 * 
	 * @return true if queue is full
	 */
	boolean isFull();
}
