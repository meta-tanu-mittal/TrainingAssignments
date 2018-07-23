package com.metacube.training.task2;

import java.util.Scanner;

public class StackUsingLinkList {
	private Node head; // the first node
	
	
	private class Node {
		int value;
		Node next;
	}
 
	public StackUsingLinkList() {
		head = null;
	}
 
	public int pop() {
		if (head == null) {
			return -1;
		}
		int value = head.value;
		head = head.next;
		return value;
	}
 
	public void push(int value) {
		Node oldHead = head;
		head = new Node();
		head.value = value;
		head.next = oldHead;
	}
	
	void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value+"\t");
			temp = temp.next;
		}
		
		
	}
 

	public static void main(String args[])
	{
		StackUsingLinkList obj=new StackUsingLinkList();
		int choice;
		Scanner sc = new Scanner(System.in);
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
