package com.metacube.training.task2;

public class PolynomialMain {
	public static void main(String[] args) {
		Polynomial polynomial1=new Polynomial(new int[][]{{2,2},{3,1},{5,0}});
		Polynomial polynomial2=new Polynomial(new int[][]{{4,1},{2,0}});
		Polynomial polynomial3=Polynomial.add(polynomial1, polynomial2);
		System.out.println("\nfirst polynomial is:");
		polynomial1.display();
		System.out.println("\nsecond polynomial is:");
		polynomial2.display();
		System.out.println("\nsum of polynomial is:");
		polynomial3.display();
		Polynomial polynomial4=Polynomial.multiply(polynomial1, polynomial2);
		System.out.println("\nmultiplication of polynomial is:");
		polynomial4.display();
	}

}
