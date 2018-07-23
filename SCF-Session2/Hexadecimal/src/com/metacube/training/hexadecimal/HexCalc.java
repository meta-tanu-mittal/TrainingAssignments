package com.metacube.training.hexadecimal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * operations on hexadecimal
 * 
 * @author Tanu Mittal
 *
 */
public class HexCalc implements Calculator {
	private String number1, number2;
	Scanner sc = new Scanner(System.in);

	/**
	 * obtain two hexadecimal number for computation
	 */
	public void getNumbers() {
		System.out.println("enter first no in hexadecimal format:");
		number1 = (sc.next()).replaceAll("^0+(?!$)", "");
		System.out.println("enter second no in hexadecimal format:");
		number2 = (sc.next()).replaceAll("^0+(?!$)", "");
	}

	/**
	 * convert hexadecimal to decimal
	 * 
	 * @param number1
	 *            is hexadecimal number
	 * @return decimal number
	 */
	public int convertHexToDecimal(String number1) {
		String num = number1.toUpperCase();
		int int_value = 0;
		int base = 1;

		for (int i = (num.length() - 1); i >= 0; i--) {
			int value = num.charAt(i);
			if (value >= '0' && num.charAt(i) <= '9') {
				int_value = int_value + ((value - 48) * base);
				base = base * 16;
			} else {
				int_value = int_value + ((value - 55) * base);
				base = base * 16;
			}
		}

		return int_value;
	}

	/**
	 * convert decimal number into hexadecimal number
	 * 
	 * @param num
	 *            is decimal number in integer
	 * @return hexadecimal format of num
	 */
	public String convertDecimalToHex(int num) {
		ArrayList<Character> lst = new ArrayList<Character>();
		int temp;
		while (num != 0) {
			temp = num % 16;
			if (temp < 10) {
				lst.add((char) (temp + 48));
			} else {
				lst.add((char) (temp + 55));
			}
			num = num / 16;
		}

		String str = "";
		for (int i = (lst.size()) - 1; i >= 0; i--) {
			str = str + lst.get(i);
		}
		return str;

	}

	/**
	 * addition two numbers in hexadecimal format
	 * 
	 * @return addition in hexadecimal format
	 */
	public String add() {
		int result = convertHexToDecimal(number1) + convertHexToDecimal(number2);
		return convertDecimalToHex(result);
	}

	/**
	 * subtraction one number from another in hexadecimal format
	 * 
	 * @return subtraction in hexadecimal format
	 */
	public String subtract() {
		String result = "0";
		int n1 = convertHexToDecimal(number1);
		int n2 = convertHexToDecimal(number2);
		int n = Math.abs(n1 - n2);
		if (n1 > n2)
			result = convertDecimalToHex(n);
		else
			result = "-" + convertDecimalToHex(n);
		return result;
	}

	/**
	 * multiply two numbers in hexadecimal format
	 * 
	 * @return multiplication in hexadecimal format
	 */
	public String multiply() {
		int result = convertHexToDecimal(number1) * convertHexToDecimal(number2);
		return convertDecimalToHex(result);
	}

	/**
	 * divide two numbers in hexadecimal format
	 * 
	 * @return division in hexadecimal format
	 */
	public String divide() {
		int result = convertHexToDecimal(number1) / convertHexToDecimal(number2);
		return convertDecimalToHex(result);
	}

	/**
	 * compare whether first number is greater than second number or not in
	 * hexadecimal format
	 */
	public boolean greaterThan() {
		boolean n = false;
		int l1 = number1.length();
		int l2 = number2.length();
		if (l1 > l2) {
			n = true;
		} else {
			if (l1 < l2) {
				n = false;
			} else {
				for (int i = 0; i < l1; i++) {
					if (number1.charAt(i) > number2.charAt(i)) {
						n = true;
						break;
					}
				}
			}
		}
		return n;

	}

	/**
	 * compare whether first number is less than second number or not in
	 * hexadecimal format
	 */
	public boolean lessThan() {
		boolean n = false;
		int l1 = number1.length();
		int l2 = number2.length();
		if (l1 < l2) {
			n = true;
		} else {
			if (l1 == l2) {
				for (int i = 0; i < l1; i++) {
					if (number1.charAt(i) < number2.charAt(i)) {
						n = true;
						break;
					}
				}
			}

		}
		return n;
	}

	/**
	 * compare whether two numbers are equal in hexadecimal format or not
	 */
	public boolean isEqual() {
		boolean n = false;
		int l1 = number1.length();
		int l2 = number2.length();
		if (l1 == l2) {
			for (int i = 0; i < l1; i++) {
				if (number1.charAt(i) == number2.charAt(i)) {
					n = true;
					break;
				}
			}
		}
		return n;
	}

}
