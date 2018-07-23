package com.metacube.training.nQueen;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenJUnitTest {

	@Test
	public void test() {
		nQueenClass obj=new nQueenClass();
		int board[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		boolean result=obj.nQueen(board,0,4);
		assertEquals(true,result);
	}
	
	@Test
	public void test1() {
		nQueenClass obj=new nQueenClass();
		int board[][]={{0,0},{0,0}};
		boolean result=obj.nQueen(board,0,2);
		assertEquals(false,result);
	}

}
