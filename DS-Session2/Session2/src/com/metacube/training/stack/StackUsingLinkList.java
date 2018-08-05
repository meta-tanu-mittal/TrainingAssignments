package com.metacube.training.stack;

/**
 * methods present in stack using link list 1 push 2 pop 3 is stack empty
 * 
 * @author user
 *
 * @param <T>
 */

public class StackUsingLinkList<T> implements StackInterface<T> {

	class Node {
		T data;
		Node next;

		public Node(T data) {
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
	public void push(T value) {
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
	public T pop() {
		if (topNode == null) {
			throw new RuntimeException("stack is empty");
		}
		T deletedValue = topNode.data;
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
	
	public T topElement()
	{
		if(!(isEmpty()))
		{
		return topNode.data;
		}
		return null;
		
	}

	/**
	 * find array of elements present in stack
	 * 
	 * @return array of elements
	 */

	T[] getObjectList() {
		Node temp = topNode;

		int noOfElements = 0;
		while (temp != null) {
			noOfElements++;
			temp = temp.next;
		}
		@SuppressWarnings("unchecked") T[] array = (T[]) new Object[noOfElements];
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
