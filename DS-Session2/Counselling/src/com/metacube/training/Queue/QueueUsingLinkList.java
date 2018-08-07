package com.metacube.training.Queue;

/**
 * operations on queue 1 add item 2 delete item 3 check if queue is full or not
 * 
 * @author user
 *
 * @param <GenericType>
 */
public class QueueUsingLinkList<GenericType> {

	public class Node {
		GenericType data;
		Node next;

		public Node(GenericType data) {
			this.data = data;
			next = null;

		}

	}

	private Node front = null;
	private Node rear = null;

	/**
	 * add item in queue
	 * 
	 * @param value
	 *            is the value to be added in queue
	 */
	public void addItem(GenericType value) {
		Node newNode = new Node(value);
		if (front == null && rear == null) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}

	}

	/**
	 * remove item from queue front end
	 * 
	 * @return removed item
	 */
	public GenericType pop() {
		if (rear == null) {
			throw new RuntimeException("no element exist in queue");
		}
		GenericType deletedValue = front.data;
		front = front.next;
		return deletedValue;
	}

	/**
	 * check if queue is empty or not
	 * 
	 * @return true if queue is empty
	 */
	public boolean isEmpty() {
		return front == null;
	}

	/**
	 * create array of items of queue
	 * 
	 * @return array
	 */
	public GenericType[] getObjectList() {
		Node temp = front;

		int noOfElements = 0;
		while (temp != null) {
			noOfElements++;
			temp = temp.next;
		}
		GenericType[] array = (GenericType[]) new Object[noOfElements];
		temp = front;
		int count = 0;
		while (temp != null) {
			array[count] = temp.data;
			count++;
			temp = temp.next;
		}
		return array;
	}

	/**
	 * display elements of queue
	 */
	public void display() {
		Node temp = front;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

}
