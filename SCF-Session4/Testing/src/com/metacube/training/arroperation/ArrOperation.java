package com.metacube.training.arroperation;

public class ArrOperation {
	/**
	 * find the size of largest mirror section appear in an array
	 * 
	 * @param mirrorArray
	 *            is an array
	 * @return size of largest mirror section
	 */
	int maxMirror(int[] mirrorArray) {

		if (mirrorArray.length == 0) {
			throw new AssertionError("array is empty");
		}

		int mirrorSize = 0;
		int tempSize = 0;
		int first, last;

		for (int i = 0; i < mirrorArray.length; i++) {
			tempSize = 0;
			for (int j = mirrorArray.length - 1; j >= 0; j--) {
				first = i;
				last = j;
				while (first < (mirrorArray.length) && last >= 0 && mirrorArray[first] == mirrorArray[last]) {
					tempSize++;
					first++;
					last--;

				}

				if (mirrorSize <= tempSize) {
					mirrorSize = tempSize;
				}
				tempSize = 0;

			}

		}
		return mirrorSize;
	}

	/**
	 * Find the index so that sum of number on one side is equal to sum of
	 * numbers on other side
	 * 
	 * @param split
	 *            is an array
	 * @return index of array where sum of elements on both side are equal
	 */
	public int splitArray(int[] split) {

		if (split.length == 0) {
			throw new AssertionError("array is empty");
		}

		int index = -1;
		int sum = 0;
		int tempSum = 0;
		for (int i = 0; i < split.length; i++) {
			sum = sum + split[i];
		}
		if (sum % 2 == 0) {
			for (int i = 0; i < split.length; i++) {
				tempSum += split[i];
				if (tempSum == sum / 2) {
					index = i + 1;
					break;
				}
			}
		}
		return index;
	}

	/**
	 * find series of two or more adjacent elements in array
	 * 
	 * @param clumpArray
	 *            is an array
	 * @return number of clumps
	 */

	public int countClumps(int[] clumpArray) {
		if (clumpArray.length == 0) {
			throw new AssertionError("array is empty");
		}

		int count = 0;

		for (int i = 0; i < clumpArray.length - 1; i++) {
			if (i == 0 && clumpArray[0] == clumpArray[1]) {
				count++;
			}
			if (i > 0) {
				if (clumpArray[i] == clumpArray[i + 1] && clumpArray[i] != clumpArray[i - 1]) {
					count++;
				} else {
					if (clumpArray[i] == clumpArray[i + 1] && clumpArray[i] != clumpArray[i - 1]) {
						continue;
					}
				}
			}
		}
		return count;
	}

	/**
	 * position of y is fixed after x
	 * 
	 * @param fixArray
	 *            is an array
	 * @param x
	 *            is a value after which y is fixed
	 * @param y
	 *            is a value to be fixed after x
	 * @return an array after fixing values of y after x
	 */
	public int[] fixXY(int[] fixArray, int x, int y) {

		if (fixArray.length == 0) {
			throw new AssertionError("array is empty");
		} else {
			int countX = 0;
			int countY = 0;
			for (int i = 0; i < fixArray.length; i++) {
				if (fixArray[i] == x) {
					countX++;
				}
				if (fixArray[i] == y) {
					countY++;
				}
			}
			if (countX != countY) {
				throw new AssertionError(x + "and" + y + " are not equal");
			} else {
				for (int i = 0; i < fixArray.length - 1; i++) {
					if (fixArray[i] == fixArray[i + 1] && fixArray[i] == x) {
						throw new AssertionError(x + " cannot be at adjacent position");
					}
				}

				if (fixArray[fixArray.length - 1] == x) {
					throw new AssertionError(x + " cannot occur at last index");
				}
			}

		}

		for (int i = 0; i < fixArray.length - 1; i++) {
			if (fixArray[i] == x && fixArray[i + 1] != y) {
				for (int j = 0; j < fixArray.length; j++) {

					if (((j == 0 && fixArray[0] == y) || j > 0 && fixArray[j] == y && fixArray[j - 1] != x)) {
						int temp;
						temp = fixArray[i + 1];
						fixArray[i + 1] = fixArray[j];
						fixArray[j] = temp;
					}
				}
			}
		}
		return fixArray;
	}

}
