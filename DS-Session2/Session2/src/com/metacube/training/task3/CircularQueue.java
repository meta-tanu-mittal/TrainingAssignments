package com.metacube.training.task3;

/**
 * In circular queue 1 add item 2 remove item 3 check whether queue is empty or
 * not 4 check whether queue is full or not
 * 
 * @author Tanu Mittal
 *
 */
public class CircularQueue implements QueueInterface {

	private int front;
	private int rear;
	private int size;
	private int[] queueArray;

	/**
	 * constructor
	 * 
	 * @param size
	 *            is size of queue
	 */
	public CircularQueue(int size) {
		front = -1;
		rear = -1;
		this.size = size;
		queueArray = new int[size];

	}

	/**
	 * add item to circular queue
	 * 
	 * @param value
	 *            is item to be added to queue
	 * 
	 */
	@Override
	public void addItem(int value) {
		if (isFull()) {
			throw new AssertionError("queue is fulls");
		}
		if (isEmpty()) {
			front = 0;
			rear = 0;

		} else {
			rear = (rear + 1) % size;
		}
		queueArray[rear] = value;
	}

	/**
	 * remove item from circular queue
	 * 
	 * @return value that is removed
	 */
	@Override
	public int removeItem() {

		int poppedItem;
		if (isEmpty()) {
			throw new AssertionError("queue is empty");
		}
		poppedItem = queueArray[front];
		front = (front + 1) % size;
		if (isEmpty()) {
			front = -1;
			rear = -1;
		}
		return poppedItem;
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
		if ((front == 0 && rear == size - 1) || (front - rear == 1)) {
			return true;
		}
		return false;
	}

	/**
	 * display elements of circular queue
	 */
	public void display() {
		if (rear >= front) {
			for (int i = front; i <= rear; i++) {
				System.out.print(queueArray[i] + " ");
			}
		} else {
			for (int i = front; i < size; i++) {
				System.out.print(queueArray[i] + " ");
			}
			for (int i = 0; i <= rear; i++) {
				System.out.print(queueArray[i] + " ");
			}
		}
	}

}
