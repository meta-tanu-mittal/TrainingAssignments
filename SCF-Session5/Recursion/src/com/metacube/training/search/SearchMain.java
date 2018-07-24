package com.metacube.training.search;

import java.util.Scanner;

public class SearchMain {
	public static void main(String args[]) {
		Search search = new Search();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size of array:");
		int n = sc.nextInt();
		int searchArray[] = new int[n];
		System.out.println("enter\n1 linear search \n 2 binary search");
		System.out.println("enter elements of array ");
		for (int i = 0; i < n; i++) {
			searchArray[i] = sc.nextInt();
		}
		System.out.print("enter the element you want to search");
		int element = sc.nextInt();
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			int position = search.linearSearch(searchArray, element);
			if (position < 0) {
				System.out.println("element not found");
			} else {
				System.out.println("position:" + position);
			}
			break;
		case 2:
			break;
		default:
			System.out.println("enter correct choice");
		}

		sc.close();
	}

}
