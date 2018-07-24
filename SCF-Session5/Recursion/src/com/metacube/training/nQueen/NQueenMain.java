package com.metacube.training.nQueen;

public class NQueenMain {
	public static void main(String args[]) {
		nQueenClass obj = new nQueenClass();
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		obj.nQueen(board, 0, 4);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

}
