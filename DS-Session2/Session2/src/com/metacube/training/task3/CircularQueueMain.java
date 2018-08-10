package com.metacube.training.task3;

/**
 * main class
 * 
 * @author Tanu Mittal
 */
public class CircularQueueMain {
	public static void main(String[] args) {
		CircularQueue obj = new CircularQueue(3);

		obj.addItem(3);
		obj.addItem(4);
		obj.addItem(5);
		System.out.println("elements of queue are:");
		obj.display();

		System.out.println("\nremoved item:" + obj.removeItem());
		System.out.println("elements of queue are:");
		obj.addItem(7);
		obj.display();
	}

}
