package com.metacube.training.jdbc;

/**
 * 
 * 
 * @author Tanu Mittal
 *
 */
public class ParentAndChild {

	private String name;
	private int noOfChild;
	
	/**
	 * constructor
	 * @param name is name of top categry
	 * @param noOfChild is no of child of top category
	 */
	public ParentAndChild(String name, int noOfChild)
	{
		this.name=name;
		this.noOfChild=noOfChild;
	}

	public int getNoOfChild() {
		return noOfChild;
	}

	public void setNoOfChild(int noOfChild) {
		this.noOfChild = noOfChild;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
