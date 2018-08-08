package com.metacube.training.priorityQueue.task2;

public class PriorityQueue {
	private int maxSize;
	private int front;
	private int rear;
	private Data queue[];

	/**
	 * constructor
	 * 
	 * @param size
	 *            is size of queue
	 */
	public PriorityQueue(int size) {
		this.maxSize = size;
		front = -1;
		rear = -1;
		queue = new Data[size];

	}

	/**
	 * add item to queue
	 * 
	 * @param data
	 *            is data added to queue
	 * @return true if data is added
	 */
	public boolean addItem(Data data) {

		try {
			if (!isFull()) {
				if (rear == -1) {
					front++;
					rear++;
				} else {
					rear = (rear + 1) % maxSize;
				}
				int position = -1;
				for (int i = front; i <= (rear - 1) % maxSize; i++) {
					if (data.getPriority() > queue[i].getPriority()) {
						position = i;
						break;
					}
				}
				if (position != -1) {
					for (int i = (rear - 1) % maxSize; i >= position; i--) {
						queue[(i + 1) % maxSize] = queue[i];
					}
					queue[position] = data;
				} else
					queue[rear] = data;

			} else
				throw new AssertionError("The queue is full!");

			return true;
		} catch (AssertionError error) {
			return false;
		}

	}

	/**
	 * remove data from queue
	 * 
	 * @return Data that is deleted from queue
	 */
	public Data removeItem() {

		Data poppedItem = null;
		if (isEmpty()) {
			throw new AssertionError("queue is empty");
		}
		if (!isEmpty()) {
			poppedItem = queue[front];
			if (front == rear) {

				front = -1;
				rear = -1;
			} else {

				front = (front + 1) % maxSize;
			}
		}
		return poppedItem;
	}

	/**
	 * check whether queue is empty or not
	 * 
	 * @return true if queue is empty
	 */
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
	public boolean isFull() {
		if ((front == 0 && rear == maxSize - 1) || (front - rear == 1)) {
			return true;
		}
		return false;
	}

}
