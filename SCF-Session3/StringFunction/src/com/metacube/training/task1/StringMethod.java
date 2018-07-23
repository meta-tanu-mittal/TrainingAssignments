package com.metacube.training.task1;

import java.util.Scanner;

public class StringMethod {
	Scanner sc = new Scanner(System.in);

	/**
	 * Compare two strings
	 * 
	 * @param s1
	 *            is first string
	 * @param s2
	 *            is second string
	 * @return true if strings are equal
	 */
	public boolean compareString(String s1, String s2) {
		boolean value = false;
		int l1 = s1.length();
		int l2 = s2.length();
		if (l1 == l2) {
			for (int i = 0; i < l1; i++) {
				if (s1.charAt(i) == s2.charAt(i)) {
					value = true;
					break;
				}
			}
		}
		return value;
	}

	/**
	 * Find reverse of string
	 * 
	 * @param str
	 *            is string to reverse
	 * @return reverse of string
	 */
	public StringBuilder reverse(String str) {
		StringBuilder rev = new StringBuilder("");
		for (int i = str.length() - 1; i >= 0; i--) {
			rev.append(str.charAt(i));
		}
		return rev;

	}

	/**
	 * Convert upper case to lower case and lower case to upper case
	 * 
	 * @param str
	 *            is string for conversion
	 * @return converted string
	 */
	public String caseConversion(String str) {
		String convert = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				convert = convert + (char) (str.charAt(i) + 32);
			} else {
				if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
					convert = convert + (char) (str.charAt(i) - 32);
				} else {
					convert = convert + (char) (str.charAt(i));
				}
			}
		}
		return convert;
	}

	/**
	 * Find largest word from string
	 * 
	 * @return largest word
	 */
	public String largestWord(String input) {

		String maximum = "";
		int maxLength = 0, count = 0;
		String checkWord = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ' ') {
				count++;
				checkWord += input.charAt(i);
			} else {
				count = 0;
				checkWord = "";
			}
			if (count >= maxLength) {
				maxLength = count;
				maximum = checkWord;
			}
		}
		return maximum;
	}
}
