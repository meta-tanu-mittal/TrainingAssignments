package com.metacube.training.stack;

/**
 * methods present in stack using link list 1 push 2 pop 3 is stack empty
 * 
 * @author user
 *
 * @param <GenericType>
 */

public class StackUsingLinkList<GenericType> implements StackInterface<GenericType> {

	class Node {
		GenericType data;
		Node next;

		public Node(GenericType data) {
			this.data = data;
			next = null;

		}

	}

	Node topNode = null;

	/**
	 * insert value in stack
	 * 
	 * @param is
	 *            the value to be inserted
	 */
	@Override
	public void push(GenericType value) {
		Node newNode = new Node(value);
		newNode.next = topNode;
		topNode = newNode;

	}

	/**
	 * remove element from stack
	 * 
	 * @return value of removed element
	 */
	@Override
	public GenericType pop() {
		if (topNode == null) {
			throw new RuntimeException("stack is full");
		}
		GenericType deletedValue = topNode.data;
		topNode = topNode.next;
		return deletedValue;
	}

	/**
	 * check if stack is empty or not
	 * 
	 * @return true if stack is empty
	 */
	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	/**
	 * find array of elements present in stack
	 * 
	 * @return array of elements
	 */

	GenericType[] getObjectList() {
		Node temp = topNode;

		int noOfElements = 0;
		while (temp != null) {
			noOfElements++;
			temp = temp.next;
		}
		GenericType[] array = (GenericType[]) new Object[noOfElements];
		temp = topNode;
		int count = 0;
		while (temp != null) {
			array[count] = temp.data;
			System.out.println(array[count]);
			count++;
			temp = temp.next;
		}
		return array;
	}

	/**
	 * display elements of stack
	 */
	void display() {
		Node temp = topNode;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

}
