package com.metacube.training;

public class Bird extends Animal {
	private double flightHeight;

	/**
	 * parametrized constructor
	 * 
	 * @param name
	 *            is name of bird
	 * @param age
	 *            is age of bird
	 * @param sound
	 *            is sound of bird
	 */
	public Bird(String name, double age, String sound) {
		super(name, age, sound);
	}

	/**
	 * @return flight height
	 */
	public double getFlightHeight() {
		return flightHeight;
	}

	/**
	 * set flight height of bird
	 * 
	 * @param flightHeight
	 */
	public void setFlightHeight(double flightHeight) {
		this.flightHeight = flightHeight;
	}

}
