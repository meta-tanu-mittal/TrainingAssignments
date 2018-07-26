package com.metacube.training.task1;

/**
 * sparse matrix 1 addition 2 multiplication 3 transpose 4 check symmetry
 * 
 * @author Tanu Mittal
 *
 */
class SparseMatrix {

	private int sparseArray[][]; /*
									 * sparseArray is 2D array in which first
									 * column represent row ,second represent
									 * column and third represent value
									 */
	private int noOfRows;
	private int noOfColumns;
	private int nonZeroElements;

	/**
	 * constructor of class
	 * 
	 * @param userArray
	 *            is the 2D array containing most of the elements as zero
	 */

	SparseMatrix(int[][] userArray) {
		noOfRows = userArray.length;
		noOfColumns = userArray[0].length;
		nonZeroElements = 0;
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				if (userArray[i][j] != 0) {
					nonZeroElements++;
				}
			}
		}
		int k = 0;
		sparseArray = new int[nonZeroElements][3];
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				if (userArray[i][j] != 0) {
					sparseArray[k][0] = i;
					sparseArray[k][1] = j;
					sparseArray[k][2] = userArray[i][j];
					k++;
				}
			}
		}
	}

	/**
	 * find transpose of sparse matrix
	 * 
	 * @return object of sparse matrix
	 */
	SparseMatrix transpose() {
		int[][] transposeArray = new int[nonZeroElements][3];
		for (int i = 0; i < nonZeroElements; i++) {
			transposeArray[i][0] = sparseArray[i][1];
			transposeArray[i][1] = sparseArray[i][0];
			transposeArray[i][2] = sparseArray[i][2];

		}
		int result[][] = new int[noOfColumns][noOfRows];
		for (int i = 0; i < nonZeroElements; i++) {
			result[transposeArray[i][0]][transposeArray[i][1]] = transposeArray[i][2];
		}
		SparseMatrix obj = new SparseMatrix(result);
		return obj;
	}

	/**
	 * find sum of two sparse matrix
	 * 
	 * @param obj1
	 *            is the first sparse matrix
	 * @param obj2
	 *            is the second sparse matrix
	 * @return sum of sparse matrix
	 */
	static SparseMatrix add(SparseMatrix obj1, SparseMatrix obj2) {
		int[][] sumMatrix = new int[obj1.noOfRows][obj1.noOfColumns];
		for (int i = 0; i < obj1.noOfRows; i++) {
			for (int j = 0; j < obj2.noOfColumns; j++) {
				sumMatrix[i][j] = obj1.getElement(i, j) + obj2.getElement(i, j);
			}
		}
		return new SparseMatrix(sumMatrix);
	}

	/**
	 * multiply two sparse matrix
	 * 
	 * @param obj1
	 *            is first sparse matrix
	 * @param obj2
	 *            is second sparse matrix
	 * @return multiplication of sparse matrix
	 */
	static SparseMatrix multiply(SparseMatrix obj1, SparseMatrix obj2) {
		int multiplyMatrix[][] = new int[obj1.noOfRows][obj2.noOfColumns];
		for (int i = 0; i < obj1.noOfRows; i++) {
			for (int j = 0; j < obj2.noOfColumns; j++) {
				for (int k = 0; k < obj1.noOfColumns; k++)

				{
					multiplyMatrix[i][j] += obj1.getElement(i, k) * obj2.getElement(k, j);
				}
			}
		}
		return new SparseMatrix(multiplyMatrix);
	}

	/**
	 * find element at particular row and column
	 * 
	 * @param row
	 * @param column
	 * @return value of element at given row and column
	 */
	int getElement(int row, int column) {
		int element = 0;
		for (int i = 0; i < nonZeroElements; i++) {
			if (sparseArray[i][0] == row && sparseArray[i][1] == column) {
				element = sparseArray[i][2];
			}
		}
		return element;
	}

	/**
	 * check whether given sparse matrix is symmetric or not
	 * 
	 * @return true if matrix is symmetric otherwise return false
	 */
	boolean checkSymmetry() {
		boolean status = true;
		for (int i = 0; i < nonZeroElements; i++) {
			if (getElement(sparseArray[i][0], sparseArray[i][1]) 
					!= getElement(sparseArray[i][1], sparseArray[i][0])) {
				status = false;
			}
		}
		return status;
	}

	/**
	 * display elements of sparse matrix
	 */
	void display() {
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				System.out.print(getElement(i, j) + " ");
			}
			System.out.println();
		}
	}

	/**
	 * find matrix
	 * 
	 * @return matrix
	 */
	int[][] getMatrix() {
		int result[][] = new int[noOfRows][noOfColumns];
		for (int i = 0; i < nonZeroElements; i++) {
			result[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		return result;
	}

}
