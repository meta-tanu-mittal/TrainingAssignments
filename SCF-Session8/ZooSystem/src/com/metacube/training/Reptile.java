package com.metacube.training;

public class Reptile extends Animal{

	/**
	 * parametrized constructor
	 * @param name is name of reptile
	 * @param age is age of reptile
	 * @param sound is sound of reptile
	 */
	public Reptile(String name, double age, String sound) {
		super(name, age, sound);
	}
	
	/**
	 * @return information of reptile
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
