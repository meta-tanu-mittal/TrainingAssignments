package com.metacube.training.task2;

/**
 * Polynomial 1. addition of two polynomial 2 multiplication of two polynomial 3
 * find highest degree of polynomial 4 valuation of polynomial
 * 
 * @author Tanu Mittal
 *
 */
public final class Polynomial {

	int polyArray[][];
	int size;

	/**
	 * this is constructor
	 * 
	 * @param polyArray
	 *            is used to initialize array
	 */
	public Polynomial(int[][] polyArray) {
		size = polyArray.length;
		this.polyArray = polyArray;
		sort();
		arrangePolynomial();
	}

	/**
	 * evaluate polynomial with some value
	 * 
	 * @param x
	 *            is the value by which polynomial is evaluated
	 * @return value after evaluation of polynomial
	 */
	double evaluate(double x) {
		double result = 0;
		for (int i = 0; i < size; i++) {
			result = result + (polyArray[i][0] * Math.pow(x, polyArray[i][1]));
		}
		return result;
	}

	/**
	 * find highest degree of polynomial
	 * 
	 * @return highest degree of polynomial
	 */
	int degree() {
		return polyArray[0][1];
	}

	/**
	 * used to display polynomial
	 */
	void display() {
		for (int i = 0; i < size - 1; i++) {
			System.out.print(polyArray[i][0] + "x^" + polyArray[i][1] + "+");
		}
		System.out.println(polyArray[size - 1][0] + "x^" + polyArray[size - 1][1]);
	}

	/**
	 * perform addition of two polynomial
	 * 
	 * @param p1
	 *            is first polynomial
	 * @param p2
	 *            is second polynomial
	 * @return sum of two polynomial
	 */
	public static Polynomial add(Polynomial p1, Polynomial p2) {
		// Polynomial obj = null;

		int n1 = p1.size;
		int n2 = p2.size;
		int[][] sum = new int[n1 + n2][2];
		int i = 0, j = 0;
		int k = 0;
		while (i < n1 && j < n2) {
			if (p1.polyArray[i][1] == p2.polyArray[j][1]) {
				sum[k][0] = p1.polyArray[i][0] + p2.polyArray[j][0];
				sum[k][1] = p1.polyArray[i][1];
				i++;
				j++;
				k++;
			} else {
				if (p1.polyArray[i][1] > p2.polyArray[j][1]) {
					sum[k][0] = p1.polyArray[i][0];
					sum[k][1] = p1.polyArray[i][1];
					i++;
					k++;
				} else {
					sum[k][0] = p2.polyArray[j][0];
					sum[k][1] = p2.polyArray[j][1];
					j++;
					k++;
				}
			}

		}

		while (i < n1) {
			sum[k][0] = p1.polyArray[i][0];
			sum[k][1] = p1.polyArray[i][1];
			i++;
			k++;
		}
		while (j < n2) {
			sum[k][0] = p2.polyArray[j][0];
			sum[k][1] = p2.polyArray[j][1];
			j++;
			k++;
		}
		int[][] newArray = new int[k][2];
		newArray = sum;
		Polynomial obj = new Polynomial(newArray);
		obj.size = k;
		return obj;
	}

	/**
	 * find multiplication of two polynomial
	 * 
	 * @param p1
	 *            is first polynomial
	 * @param p2
	 *            is second polynomial
	 * @return multiplication of two polynomial
	 */
	public static Polynomial multiply(Polynomial p1, Polynomial p2) {
		int n1 = p1.size;
		int n2 = p2.size;

		int[][] multiplyArray = new int[n1 * n2][2];
		int i = 0, j = 0;
		int k = 0;

		for (i = 0; i < n1; i++) {
			for (j = 0; j < n2; j++) {
				multiplyArray[k][0] = p1.polyArray[i][0] * p2.polyArray[j][0];
				multiplyArray[k][1] = p1.polyArray[i][1] + p2.polyArray[j][1];
				k++;
			}
		}

		int[][] newArray = new int[k][2];
		newArray = multiplyArray;
		Polynomial obj = new Polynomial(newArray);

		return obj;
	}

	/**
	 * sort 2D array according to their degree
	 */
	public void sort() {

		for (int i = 0; i < (size - 1); i++) {
			for (int j = 0; j < (size - i - 1); j++) {
				if (polyArray[j][1] < polyArray[j + 1][1]) {
					int temp1, temp2;
					temp1 = polyArray[j][1];
					temp2 = polyArray[j][0];
					polyArray[j][1] = polyArray[j + 1][1];
					polyArray[j][0] = polyArray[j + 1][0];
					polyArray[j + 1][1] = temp1;
					polyArray[j + 1][0] = temp2;
				}
			}
		}
	}

	/**
	 * storing same degree term at one index
	 */
	void arrangePolynomial() {
		for (int i = 0; i < size - 1; i++) {
			if (polyArray[i][1] == polyArray[i + 1][1]) {
				polyArray[i][0] += polyArray[i + 1][0];
				for (int j = i + 1; j < size - 1; j++) {
					polyArray[j][0] = polyArray[j + 1][0];
					polyArray[j][1] = polyArray[j + 1][1];
				}
				size--;
			}
		}

	}

	/**
	 * @return 2D array of polynomial
	 */

	int[][] getArray() {
		return polyArray;
	}

}
