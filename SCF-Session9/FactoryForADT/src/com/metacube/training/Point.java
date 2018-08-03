package com.metacube.training;

/**
 * @author Tanu Mittal
 *
 */
public class Point {
	private double x;
	private double y;

	/**
	 * default constructor
	 */
	public Point() {

	}

	/**
	 * constructor
	 * 
	 * @param x
	 *            is x coordinate
	 * @param y
	 *            is y coordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return x coordinate
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return y coordinate
	 */
	public double getY() {
		return y;
	}

}
