package com.metacube.training.dictionary.task;

import java.util.List;

/**
 * Dictionary interface
 * 
 * @author Tanu Mittal
 *
 */
public interface Dictionary {
	/**
	 * add data to sheet
	 * 
	 * @param data
	 *            is data to be added to dictionary
	 */
	void addEntry(Data data);

	/**
	 * delete data from dictionary
	 * 
	 * @param key
	 *            is a value corresponding to which data is deleted
	 */
	void deleteEntry(String key);

	/**
	 * @return sorted list of data
	 */
	List<Data> getSortedList();

	/**
	 * search for a value corresponding to key
	 * 
	 * @param key
	 *            is a key to be searched
	 * @return value
	 */
	String searchValueFromKey(String key);

	/**
	 * find data between two keys
	 * 
	 * @param key1
	 *            is first key
	 * @param key2
	 *            is second key
	 * @return list of data
	 */
	List<Data> findBetweenKeys(String key1, String key2);

}
