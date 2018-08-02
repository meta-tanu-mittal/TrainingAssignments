package com.metacube.training.task1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseJUnitTest {

	SparseMatrix obj1 = new SparseMatrix(
			new int[][] { { 0, 10, 0, 12 }, { 0, 0, 0, 0 }, { 0, 0, 5, 0 }, { 15, 12, 0, 0 } });
	SparseMatrix obj2 = new SparseMatrix(
			new int[][] { { 0, 0, 8, 0 }, { 0, 0, 0, 23 }, { 0, 0, 9, 0 }, { 20, 25, 0, 0 } });

	@Test
	public void testTranspose() {
		SparseMatrix obj3 = obj1.transpose();
		int transpose[][] = new int[][] { { 0, 0, 0, 15 }, { 10, 0, 0, 12 }, { 0, 0, 5, 0 }, { 12, 0, 0, 0 } };
		assertArrayEquals(transpose, obj3.getMatrix());

	}

	@Test
	public void testAddition() {
		SparseMatrix obj3 = SparseMatrix.add(obj1, obj2);
		int sum[][] = new int[][] { { 0, 10, 8, 12 }, { 0, 0, 0, 23 }, { 0, 0, 14, 0 }, { 35, 37, 0, 0 } };
		assertArrayEquals(sum, obj3.getMatrix());

	}

	@Test
	public void testMultiplication() {
		SparseMatrix obj3 = SparseMatrix.multiply(obj1, obj2);
		int multiplication[][] = new int[][] { { 240, 300, 0, 230 }, { 0, 0, 0, 0 }, { 0, 0, 45, 0 },
				{ 0, 0, 120, 276 } };
		assertArrayEquals(multiplication, obj3.getMatrix());

	}

	@Test
	public void testSymmetry1() {
		assertEquals(false, obj1.checkSymmetry());

	}

	@Test
	public void testSymmetry2() {
		SparseMatrix obj3 = new SparseMatrix(new int[][] { { 0, 5, 0 }, { 5, 0, 7 }, { 0, 7, 0 } });
		assertEquals(true, obj3.checkSymmetry());

	}

}
