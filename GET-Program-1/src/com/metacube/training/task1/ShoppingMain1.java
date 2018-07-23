package com.metacube.training.task1;

import java.util.Scanner;

public class ShoppingMain1 {
	public static void main(String args[]) {
		int choice;
		Item itemObject = new Item();
		itemObject.displayAllItems();
		Scanner sc = new Scanner(System.in);

		System.out.println("Want to add item in cart?\nenter y for yes and n for no");
		String input = sc.next();
		while (Constants.YES.equals(input)) {
			itemObject.insert();
			System.out.print("Want to add more item in cart? \nenter y for yes and n for no:");
			input = sc.next();
		}

		boolean flag = true;
		while (flag) {
			System.out.println("enter");
			System.out.print(
					"1 remove element from cart \n2 display all items in cart with total amount\n3 update quantity \n4 want to add more item\n6 exit\n");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("enter the id of element to be removed:");
				itemObject.remove(sc.nextInt());
				break;
			case 2:
				itemObject.display();
				System.out.println("total amount=\t" + itemObject.totalAmount());
				break;
			case 3:
				itemObject.update();
				itemObject.display();
				break;
			case 4:
				itemObject.insert();
				break;
			case 5:
				flag = false;

			default:
				System.out.println("enter your choice correctly");
			}
		}
		sc.close();

	}

}
