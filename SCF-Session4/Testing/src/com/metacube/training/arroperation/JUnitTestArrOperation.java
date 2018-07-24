package com.metacube.training.arroperation;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTestArrOperation {
	@Test
	public void test1() {
		ArrOperation arrOperation=new ArrOperation();
		int mirrorSize=arrOperation.maxMirror(new int[]{1,2,3,8,9,3,2,1});
		assertEquals(3, mirrorSize);
	}
	
	@Test
	public void test11() {
		ArrOperation arrOperation=new ArrOperation();
		int mirrorSize=arrOperation.maxMirror(new int[]{7,1,4,9,7,4,1});
		assertEquals(2, mirrorSize);
	}
	
	@Test
	public void test111() {
		ArrOperation arrOperation=new ArrOperation();
		int mirrorSize=arrOperation.maxMirror(new int[]{1,2,1,4});
		assertEquals(3, mirrorSize);
	}
	
	@Test
	public void test1111() {
		ArrOperation arrOperation=new ArrOperation();
		int mirrorSize=arrOperation.maxMirror(new int[]{1,4,5,3,5,4,1});
		assertEquals(7, mirrorSize);
	}
	
	@Test
	public void test2() {
		ArrOperation arrOperation=new ArrOperation();
		int noOfClumps=arrOperation.countClumps(new int[]{1,2,2,3,4,4});
		assertEquals(2, noOfClumps);
	}
	
	@Test
	public void test21() {
		ArrOperation arrOperation=new ArrOperation();
		int noOfClumps=arrOperation.countClumps(new int[]{1,1,2,1,1});
		assertEquals(2, noOfClumps);
	}
    
	@Test
	public void test211() {
		ArrOperation arrOperation=new ArrOperation();
		int noOfClumps=arrOperation.countClumps(new int[]{1,1,1,1,1});
		assertEquals(1, noOfClumps);
	}
	
	
	@Test
	public void test3() {
		ArrOperation arrOperation=new ArrOperation();
		int[] fixArray=arrOperation.fixXY(new int[]{5,4,9,4,9,5},4,5);
		assertArrayEquals(new int[]{9,4,5,4,5,9}, fixArray);
	}
	
	@Test
	public void test31() {
		ArrOperation arrOperation=new ArrOperation();
		int[] fixArray=arrOperation.fixXY(new int[]{1,4,1,5},4,5);
		assertArrayEquals(new int[]{1,4,5,1}, fixArray);
	}
	
	@Test
	public void test311() {
		ArrOperation arrOperation=new ArrOperation();
		int[] fixArray=arrOperation.fixXY(new int[]{1,4,1,5,5,4,1},4,5);
		assertArrayEquals(new int[]{1,4,5,1,1,4,5}, fixArray);
	}
	
	
	
	@Test
	public void test4() {
		ArrOperation arrOperation=new ArrOperation();
		int indexOfSplitArray=arrOperation.splitArray(new int[]{1,1,1,2,1});
		assertEquals(3,indexOfSplitArray);
	}
	
	@Test
	public void test41() {
		ArrOperation arrOperation=new ArrOperation();
		int indexOfSplitArray=arrOperation.splitArray(new int[]{2,1,1,2,1});
		assertEquals(-1,indexOfSplitArray);
	}
	
	@Test
	public void test411() {
		ArrOperation arrOperation=new ArrOperation();
		int indexOfSplitArray=arrOperation.splitArray(new int[]{10,10});
		assertEquals(1,indexOfSplitArray);
	}
	
	

}
