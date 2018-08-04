package com.metacube.training;

public class Tiger extends Mammal {

	/**
	 * parametrized constructor
	 * 
	 * @param name
	 * @param age
	 * @param sound
	 */
	public Tiger(String name, double age, String sound) {
		super(name, age, sound);
	}

	/**
	 * @return information of tiger
	 */
	public String getInfo() {
		return "Name=" + getName() + "\nAge=" + getAge() + "\nSound=" + getSound() + "\nCategory=" + getCategory()
				+ "\nType=" + getType();
	}

}
