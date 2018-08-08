package com.metacube.training.match.task3;

/**
 * @author Tanu Mittal
 *
 */
public class Bowler {
	private String name;
	private int numberOfBalls;

	/**
	 * default constructor
	 */
	public Bowler() {

	}

	/**
	 * constructor
	 * 
	 * @param name
	 *            is name of bowler
	 * @param numberOfBalls
	 *            of bowler
	 */
	public Bowler(String name, int numberOfBalls) {
		this.name = name;
		this.numberOfBalls = numberOfBalls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfBalls() {
		return numberOfBalls;
	}

	public void setNumberOfBalls(int numberOfBalls) {
		this.numberOfBalls = numberOfBalls;
	}

}
