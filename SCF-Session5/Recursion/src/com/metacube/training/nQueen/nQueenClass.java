package com.metacube.training.nQueen;

public class nQueenClass {

	/**
	 * check whether queen will fit in board or not
	 * 
	 * @param board
	 *            is a 2*2 board
	 * @param row
	 * @param column
	 * @param dimensionOfMatrix
	 * @return true if queen can fit on board
	 */
	boolean isSafe(int[][] board, int row, int column, int dimensionOfMatrix) {
		int i, j;
		for (i = 0; i < row; i++) {
			if (board[i][column] == 1) {
				return false;
			}
		}

		for (i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		for (i = row, j = column; i >= 0 && j < dimensionOfMatrix; i--, j++) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

	/**
	 * check whether all queen fit on a board or not
	 * 
	 * @param board
	 *            is a board of n*n
	 * @param startRow
	 * @param dimensionOfMatrix
	 * @return
	 */
	boolean nQueen(int[][] board, int startRow, int dimensionOfMatrix) {
		boolean queenPlaced = false;
		for (int i = 0; i < dimensionOfMatrix; i++) {
			queenPlaced = isSafe(board, startRow, i, dimensionOfMatrix);
			if (queenPlaced) {
				board[startRow][i] = 1;
				startRow++;
				if (startRow == dimensionOfMatrix) {
					queenPlaced = true;
					break;
				}
				if (!nQueen(board, startRow, dimensionOfMatrix)) {
					startRow--;
					board[startRow][i] = 0;
					queenPlaced = false;
				} else {
					break;
				}

			}
		}
		return queenPlaced;
	}

}
