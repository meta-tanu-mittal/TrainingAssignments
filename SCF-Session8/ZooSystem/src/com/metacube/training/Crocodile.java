package com.metacube.training;

public class Crocodile extends Reptile {
	/**
	 * parametrized constructor
	 * 
	 * @param name
	 *            is name of crocodile
	 * @param age
	 *            is age of crocodile
	 * @param sound
	 *            is sound of crocodile
	 */
	public Crocodile(String name, double age, String sound) {
		super(name, age, sound);
	}

	/**
	 * @return information of crocodile
	 */
	public String getInfo() {
		return "Name=" + getName() + "\nAge=" + getAge() + "\nSound=" + getSound() + "\nCategory=" + getCategory()
				+ "\nType=" + getType();
	}

}
