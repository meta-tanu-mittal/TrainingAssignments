package com.metacube.training.hexadecimal;

import java.util.Scanner;

public class HexMain {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		HexCalc obj = new HexCalc();
		boolean flag = true;
		while (flag) {
			System.out.println("enter to perform operation");
			System.out.println(
					"1 convert hexadecimal to decimal \n2 convert decimal to hexadecimal \n3 add \n4 subtract \n5 multiply \n6 divide \n7 greter than \n8 less than \n9 is equal \n10 exit");
			;
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("enter string:");
				String str = sc.next();
				System.out.println("decimal format:" + obj.convertHexToDecimal(str));
				break;
			case 2:
				System.out.print("enter decimal number:");
				int a = sc.nextInt();
				System.out.println("hexadecimal format:" + obj.convertDecimalToHex(a));
				break;
			case 3:
				obj.getNumbers();
				System.out.println("addition:" + obj.add());
				break;
			case 4:
				obj.getNumbers();
				System.out.println("subtraction:" + obj.subtract());
				break;
			case 5:
				obj.getNumbers();
				System.out.println("multiplication:" + obj.multiply());
				break;
			case 6:
				obj.getNumbers();
				System.out.println("divison:" + obj.divide());
				break;
			case 7:
				obj.getNumbers();
				System.out.println("first number is greater than second number:" + obj.greaterThan());
				break;
			case 8:
				obj.getNumbers();
				System.out.println("first number is less than second number:" + obj.lessThan());
				break;
			case 9:
				obj.getNumbers();
				System.out.println("first number is equal to second number:" + obj.isEqual());
				break;
			case 10:
				flag = false;

			default:
				System.out.println("enter correct value");

			}

		}
		sc.close();

	}

}
