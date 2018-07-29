package com.metacube.training.hexadecimal;

import java.util.ArrayList;

/**
 * operations on hexadecimal
 * 
 * @author Tanu Mittal
 *
 */
public class HexCalc {
	String number;

	/**
	 * constructor
	 * 
	 * @param number
	 *            is a hexadecimal number
	 */
	public HexCalc(String number) {
		this.number = number.replaceAll("^0+(?!$)", "");
	}

	/**
	 * convert hexadecimal number to decimal number
	 * 
	 * @return decimal number
	 */
	public int convertHexToDecimal() {
		String num = number.toUpperCase();
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
	 * addition of two hexadecimal number
	 * 
	 * @param obj
	 *            is hexadecimal number
	 * @return sum of two hexadecimal number
	 */
	public String add(HexCalc obj) {
		int result = convertHexToDecimal() + obj.convertHexToDecimal();
		return convertDecimalToHex(result);
	}

	/**
	 * subtraction of one hexadecimal number from another number
	 * 
	 * @param obj
	 *            is number to be subtracted
	 * @return difference of two numbers
	 */
	public String subtract(HexCalc obj) {
		String result = "0";
		int n1 = convertHexToDecimal();
		int n2 = obj.convertHexToDecimal();
		int n = Math.abs(n1 - n2);
		if (n1 > n2)
			result = convertDecimalToHex(n);
		else
			result = "-" + convertDecimalToHex(n);
		return result;
	}

	/**
	 * multiply two hexadecimal numbers
	 * 
	 * @param obj
	 *            is hexadecimal number
	 * @return multiplication of two numbers
	 */
	public String multiply(HexCalc obj) {
		int result = convertHexToDecimal() * obj.convertHexToDecimal();
		return convertDecimalToHex(result);
	}

	/**
	 * divide hexadecimal numbers
	 * 
	 * @param obj
	 *            is hexadecimal number
	 * @return division of two numbers
	 */
	public String divide(HexCalc obj) {
		int result = convertHexToDecimal() / obj.convertHexToDecimal();
		return convertDecimalToHex(result);
	}

	/**
	 * find if one number is greater than other or not
	 * 
	 * @param obj
	 *            is hexadecimal object
	 * @return true if number is greater than other number
	 */
	public boolean greaterThan(HexCalc obj) {
		boolean n = false;
		int l1 = number.length();
		int l2 = obj.number.length();
		if (l1 > l2) {
			n = true;
		} else {
			if (l1 < l2) {
				n = false;
			} else {
				for (int i = 0; i < l1; i++) {
					if (number.charAt(i) > obj.number.charAt(i)) {
						n = true;
						break;
					}
				}
			}
		}
		return n;

	}

	/**
	 * find if one number is less than other or not
	 * 
	 * @param obj
	 *            is hexadecimal object
	 * @return true if number is less than other number
	 */
	public boolean lessThan(HexCalc obj) {
		boolean n = false;
		int l1 = number.length();
		int l2 = obj.number.length();
		if (l1 < l2) {
			n = true;
		} else {
			if (l1 == l2) {
				for (int i = 0; i < l1; i++) {
					if (number.charAt(i) < obj.number.charAt(i)) {
						n = true;
						break;
					}
					if (number.charAt(i) > obj.number.charAt(i)) {
						n = false;
						break;
					}

				}
			}

		}
		return n;
	}

	/**
	 * find if one number is equal to other or not
	 * 
	 * @param obj
	 *            is hexadecimal object
	 * @return true if number is equal to other number
	 */
	public boolean isEqual(HexCalc obj) {
		boolean n = false;
		int l1 = number.length();
		int l2 = obj.number.length();
		if (l1 == l2) {
			for (int i = 0; i < l1; i++) {
				if (number.charAt(i) == obj.number.charAt(i)) {
					n = true;
					break;
				}
			}
		}
		return n;
	}

}
