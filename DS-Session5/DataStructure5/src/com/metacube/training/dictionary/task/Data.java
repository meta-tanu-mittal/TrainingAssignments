package com.metacube.training.dictionary.task;

/**
 * class that contain words and meaning for dictionary
 * 
 * @author user
 *
 */
public class Data {

	private String key;
	private String value;

	/**
	 * default constructor
	 */
	public Data() {

	}

	/**
	 * constructor
	 * 
	 * @param key
	 *            is word
	 * @param value
	 *            is meaning
	 */
	public Data(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
