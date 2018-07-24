package com.metacube.training.commonFactors;

import java.util.Scanner;

public class MainClass {
	public static void main(String args[]) {
		int n1, n2;
		Scanner sc = new Scanner(System.in);
		CommonFactors commonFactors = new CommonFactors();
		System.out.println("enter two numbers:");
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		System.out.println("enter \n1 to find lcm \n2 to find HCF");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			int lcm;
			if (n1 > n2) {
				lcm = commonFactors.findLCM(n2, n1);
			} else {
				lcm = commonFactors.findLCM(n1, n2);
			}
			System.out.println("lcm=" + lcm);
			break;
		case 2:
			int hcf;
			hcf=commonFactors.findHCF(n1, n2);
			System.out.println("hcf="+hcf);
			break;
		default:
			System.out.println("enter correct value");
		}
		sc.close();

	}

}
