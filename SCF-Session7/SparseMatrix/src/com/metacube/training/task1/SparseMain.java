package com.metacube.training.task1;

public class SparseMain {
	public static void main(String[] args) {
		SparseMatrix obj1 = new SparseMatrix(
				new int[][] { { 0, 10, 0, 12 }, { 0, 0, 0, 0 }, { 0, 0, 5, 0 }, { 15, 12, 0, 0 } });
		SparseMatrix obj2 = new SparseMatrix(
				new int[][] { { 0, 0, 8, 0 }, { 0, 0, 0, 23 }, { 0, 0, 9, 0 }, { 20, 25, 0, 0 } });
		System.out.println("first matrix is:");
		obj1.display();
		System.out.println("second matrix is");
		obj2.display();
		System.out.println("transpose of first matrix is:");
		SparseMatrix obj3 = obj1.transpose();
		obj3.display();
		SparseMatrix obj4 = SparseMatrix.add(obj1, obj2);
		System.out.println("addition of first and second matrix is:");
		obj4.display();
		SparseMatrix obj5 = SparseMatrix.multiply(obj1, obj2);
		System.out.println("multiplication of first and second matrix is:");
		obj5.display();

	}

}
