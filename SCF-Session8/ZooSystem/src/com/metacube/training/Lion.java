package com.metacube.training;

public class Lion extends Mammal {

	/**
	 * parametrized constructor
	 * @param name is name of lion
	 * @param age is age of lion
	 * @param sound is sound of lion
	 */
	public Lion(String name, double age, String sound) {
		super(name, age, sound);
	}
	
	/**
	 * @return information of lion
	 */
	public String getInfo()
	{
		return "Name="+getName()+
				"\nAge="+getAge()+
				"\nSound="+getSound()+
				"\nCategory="+getCategory()+
				"\nType="+getType();
	}

	

}
