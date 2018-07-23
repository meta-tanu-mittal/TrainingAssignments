package com.metacube.training.task2;

import java.util.Scanner;

class UseStack {
	static private int max = 10;
	private int stack[] = new int[max];
	private int topIndex = -1;
	Scanner sc1 = new Scanner(System.in);

	/**
	 * enter the element is stack at top position
	 * 
	 * @param a
	 *            is the element at top index
	 */
	void push(int a) {
		if (top() == (max - 1))
			System.out.println("stack is full");
		else {
			topIndex++;
			stack[topIndex] = a;
		}
	}

	/**
	 * delete the element from top index
	 * 
	 * @return the element that is deleted
	 */
	int pop() {
		int n;
		if (isEmpty()) {
			System.out.println("stack is empty");
			return -1;
		} else {
			n = stack[topIndex];
			topIndex--;
			return n;
		}
	}

	/**
	 * check whether stack is empty or not
	 * 
	 * @return true if stack is empty
	 */
	boolean isEmpty() {
		if (top() == -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * find index of top element in stack
	 * 
	 * @return index of top element
	 */
	int top() {
		return topIndex;
	}

	/**
	 * 
	 * display all the elements present in stack
	 */
	void display() {
		int i;
		if (top() == -1) {
			System.out.println("stack is empty");
		} else {
			for (i = 0; i <= topIndex; i++) {
				System.out.print(stack[i] + "\t");
			}
		}
	}
}

public class StackImplementation {
	public static void main(String args[]) {
		int choice;
		Scanner sc = new Scanner(System.in);
		UseStack obj = new UseStack();
		boolean flag = true;
		while (flag) {
			System.out.println("enter the following: \n1 push \n2 pop \n3 display elements\n4 exit ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter the no to be inserted:");
				obj.push(sc.nextInt());
				break;
			case 2:
				int a = obj.pop();
				if (a == -1) {
				} else
					System.out.println("element to be popped out:" + a);
				break;
			case 3:
				obj.display();
				break;
			case 4:
				flag = false;
			default:
				System.out.println("enter your choice correctly");
			}
			// sc.close();

		}

	}

}
