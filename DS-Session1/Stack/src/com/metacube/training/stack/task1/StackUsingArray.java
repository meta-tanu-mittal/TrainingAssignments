package com.metacube.training.stack.task1;

/**
 * Operation performed in stack 1 push 2 pop 3 is stack empty or not
 * 
 * @author Tanu Mittal
 *
 * @param <GenericType>
 *            is used for passing generic values in stack
 */
public class StackUsingArray<GenericType> implements StackInterface<GenericType> {
	private int max;
	private GenericType[] stack;
	private int topIndex = -1;

	/**
	 * default constructor
	 */
	public StackUsingArray() {

	}

	/**
	 * parametrized constructor
	 * 
	 * @param size
	 *            is maximum size of stack
	 */
	public StackUsingArray(int size) {
		max = size;
		stack = (GenericType[]) new Object[max];
	}

	/**
	 * add item in stack
	 * 
	 * @param value
	 *            is item to be added in stack
	 */
	@Override
	public void push(Object value) {
		if (top() == (max - 1))
			throw new AssertionError("stack overflow");
		else {
			topIndex++;
			stack[topIndex] = (GenericType) value;
		}
	}

	/**
	 * remove item from stack
	 * 
	 * @return value of item to be removed
	 */
	@Override
	public GenericType pop() {
		GenericType removedElement;
		if (isEmpty()) {
			throw new AssertionError("stack underflow");
		} else {
			removedElement = (GenericType) stack[topIndex];
			topIndex--;

		}
		return removedElement;
	}

	/**
	 * check whether stack is empty or not
	 * 
	 * @return true if stack is empty
	 */
	@Override
	public boolean isEmpty() {
		if (top() == -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return top index of stack
	 */
	public int top() {
		return topIndex;
	}

	/**
	 * store items of stack in array
	 * 
	 * @return array of items
	 */
	public GenericType[] getObjectList() {
		GenericType[] array = (GenericType[]) new Object[top() + 1];
		for (int i = 0; i <= top(); i++)
			array[i] = stack[i];
		return array;
	}

	/**
	 * display stack content
	 */
	void display() {
		for (int i = 0; i <= top(); i++)
			System.out.println(stack[i]);
	}

}
