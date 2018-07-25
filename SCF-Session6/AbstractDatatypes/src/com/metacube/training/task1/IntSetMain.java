package com.metacube.training.task1;

public class IntSetMain {
	public static void main(String[] args) {
		IntSet obj1 = new IntSet(new int[] { 2, 4, 6, 8, 1, 0, 1, 2, 3, 7 });
		IntSet obj2 = new IntSet(new int[] { 6, 8, 10 });
		System.out.println("first set is:");
		obj1.display();
		System.out.println("\nsecond set is:");
		obj2.display();
		IntSet obj3=IntSet.union(obj1, obj2);
		System.out.println("\nunion of two set is:");
		obj3.display();
		
	}

}
