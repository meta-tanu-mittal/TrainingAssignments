package com.metacube.training.search;

public class Search {
	static int position = -1;

	/**
	 * search an element in an array
	 * 
	 * @param arr
	 *            is an array
	 * @param a
	 *            is the element to be searched
	 * @return position of element
	 */
	int linearSearch(int[] arr, int a) {
		int found = 0;
		position++;
		if (arr[position] == a) {
			found = 1;
		}
		if (found == 0 && position == arr.length - 1)
			return -1;
		if (found == 1)
			return position;
		return linearSearch(arr, a);

	}

	/**
	 * search element in an array
	 * 
	 * @param arr
	 *            is an array
	 * @param a
	 *            is the element to be searched
	 * @param first
	 *            is the first position in array
	 * @param last
	 *            is the last position in an array
	 * @return the position of an element
	 */

	int binarySearch(int[] arr, int a, int first, int last) {
		int len = arr.length;
		int mid = (first + last) / 2;
		if (len == 0)
			return -1;
		if (arr[mid] == a)
			return mid;
		else {
			if (arr[mid] > a) {
				// first=0;
				last = mid - 1;
			} else {
				first = mid + 1;
				// last=len;
			}
		}
		return binarySearch(arr, a, first, last);

	}

}
