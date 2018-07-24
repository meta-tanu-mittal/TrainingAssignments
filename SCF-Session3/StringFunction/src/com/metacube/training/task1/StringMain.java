package com.metacube.training.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StringMain {
	public static void main(String args[]) {
		StringMethod obj = new StringMethod();
		Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while (flag) {
			System.out.println("1 compare string \n2 reverse \n3 case conversion \n4 find largest word \n5 exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("enter first strings");
				String s1 = sc.next();
				System.out.print("enter second strings");
				String s2 = sc.next();
				if (obj.compareString(s1, s2))
					System.out.println("strings are equal");
				else
					System.out.println("strings are not equal");
				break;
			case 2:
				System.out.print("enter string:");
				String s = "";
				try {
					s = bf.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("reverse :" + obj.reverse(s));
				break;
			case 3:

				System.out.print("enter string:");
				System.out.println("case conversion :" + obj.caseConversion(sc.next()));
				break;
			case 4:
				System.out.print("enter string:");
				String str = "";
				try {
					str = bf.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("largest word:" + obj.largestWord(str));
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
