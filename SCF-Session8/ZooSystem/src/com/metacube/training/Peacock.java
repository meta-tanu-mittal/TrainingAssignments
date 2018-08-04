package com.metacube.training;

public class Peacock extends Bird {

	/**
	 * parametrized constructor
	 * 
	 * @param name
	 *            is name of peacock
	 * @param age
	 *            is age of peacock
	 * @param sound
	 *            is sound of peacock
	 * @param flightHeight
	 *            is height can be taken by peacock
	 */
	public Peacock(String name, double age, String sound, double flightHeight) {
		super(name, age, sound);
		setFlightHeight(flightHeight);
	}

	/**
	 * @return information of peacock
	 */
	public String getInfo() {
		return "Name=" + getName() + "\nAge=" + getAge() + "\nSound=" + getSound() + "\nCategory=" + getCategory()
				+ "\nType=" + getType() + "\nFlightHeight=" + getFlightHeight();
	}

}
