package com.metacube.training.task2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * count number of characters in string
 * 
 * @author Tanu Mittal
 *
 */
public class CharacterCount {
	private HashMap<String, Integer> cache;

	/**
	 * constructor
	 */
	public CharacterCount() {
		cache = new HashMap<String, Integer>();

	}

	/**
	 * count number of character in string if string is present in cache,
	 * otherwise insert in cache
	 * 
	 * @param str
	 *            is a string in which number of characters are counted
	 * @return no of characters in string
	 */
	public int getCountOfCharacterInString(String str) {
		int noOfUniqueCharacter = 0;
		if (cache.size() == 0 || !(cache.containsKey(str))) {
			noOfUniqueCharacter = countUniqueCharacter(str);
			cache.put(str, noOfUniqueCharacter);

		} else {
			if (cache.containsKey(str)) {
				noOfUniqueCharacter = cache.get(str);
			}
		}

		return noOfUniqueCharacter;
	}

	/**
	 * count number of character in string if string is not present in cache
	 * 
	 * @param str
	 *            is a string in which number of characters are counted
	 * @return number of character in string
	 */
	public int countUniqueCharacter(String str) {
		Set<Character> listOfCharacter = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			listOfCharacter.add(str.charAt(i));
		}
		return listOfCharacter.size();
	}

}
