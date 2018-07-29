package com.metacube.training.area;

import java.util.Scanner;

public class AreaMain {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Area obj = new Area();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter to find area of following:");
			System.out.println("1 triangle \n2 rectangle \n3 square \n4 circle");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter width and height of triangle");
				double width = 0, height = 0;
				try {

					width = sc.nextDouble();
					height = sc.nextDouble();
				} catch (ArithmeticException e) {
					e.printStackTrace();
				}

				System.out.println("area of triangle is:" + obj.triangleArea(width, height));
				break;
			case 2:
				System.out.println("enter width and height of rectangle");
				double width1 = 0, height1 = 0;
				try {
					width1 = sc.nextDouble();
					height1 = sc.nextDouble();
				} catch (ArithmeticException e) {
					e.printStackTrace();
				}
				System.out.println("area of rectangle is:" + obj.rectangleArea(width1, height1));
				break;
			case 3:
				System.out.println("enter width of square");
				double width11 = 0;
				try {
					width11 = sc.nextDouble();
				} catch (ArithmeticException e) {
					e.printStackTrace();
				}
				System.out.println("area of square is:" + obj.squareArea(width11));
				break;
			case 4:
				System.out.println("enter radius of circle");
				double radius = 0;
				try {
					radius = sc.nextDouble();
				} catch (ArithmeticException e) {
					e.printStackTrace();
				}
				System.out.println("area of circle is:" + obj.circleArea(radius));
				break;
			case 5:
				flag = false;
			default:
				System.out.println("enter correct input");

			}

		}
		sc.close();

	}

}
