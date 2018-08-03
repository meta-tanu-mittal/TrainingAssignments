package com.metacube.training.task2;

/**
 * operations in class 1 add item 2 remove item 3 check if queue is empty
 * 
 * @author Tanu Mittal
 *
 * @param <GenericType>
 *            is used to perform operations on any type of value
 */
public class QueueUsingArray<T> implements QueueInterface<T> {

	private int front = -1;
	private int rear = -1;
	private int maxSize;
	private T[] queueArray;

	/**
	 * default constructor
	 */
	public QueueUsingArray() {

	}

	/**
	 * parametrized constructor
	 * 
	 * @param max
	 *            is the maximum size of queue
	 */
	public QueueUsingArray(int max) {
		maxSize = max;
		queueArray = (T[]) new Object[maxSize];
	}

	/**
	 * add item in queue
	 * 
	 * @param value
	 *            is item to be added
	 */
	@Override
	public void addItem(T value) {
		if (front == -1 && rear == -1) {
			front++;
			rear++;
			queueArray[rear] = value;

		} else {
			rear++;
			queueArray[rear] = value;
		}
	}

	/**
	 * remove value at front end from queue
	 * 
	 * @return deleted value
	 */
	@Override
	public T removeItem() {

		T removedItem;
		if (!(isEmpty())) {
			removedItem = queueArray[front];
			front++;
			return removedItem;
		}

		return null;
	}

	/**
	 * check whether queue is empty or not
	 * 
	 * @return true if queue is empty
	 */
	@Override
	public boolean isEmpty() {
		if (front == -1 && rear == -1) {
			return true;
		}
		return false;
	}

	/**
	 * check whether queue is full or not
	 * 
	 * @return true if queue is full
	 */
	@Override
	public boolean isFull() {
		if (front == 0 && rear == (maxSize - 1)) {
			return true;
		}
		return false;
	}

	/**
	 * create array to store all items of queue
	 * 
	 * @return array
	 */
	public T[] getObjectList() {
		T[] array = (T[]) new Object[rear - front + 1];
		for (int i = front; i <= rear; i++)
			array[i] = queueArray[i];
		return array;
	}

}
