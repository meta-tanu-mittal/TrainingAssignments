package com.metacube.training.match.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * find order of bowlers
 * 
 * @author Tanu Mittal
 *
 */
public class Match {
	int ballsOfPlayer;
	List<Bowler> listOfBowler;
	List<Bowler> listOfBallsThrown;

	/**
	 * constructor
	 * 
	 * @param ballsOfPlayer
	 *            is the number of balls played by bowler
	 * @param listOfBowler
	 *            is list of Bowler
	 */
	public Match(int ballsOfPlayer, List<Bowler> listOfBowler) {
		this.ballsOfPlayer = ballsOfPlayer;
		this.listOfBowler = listOfBowler;
	}

	/**
	 * find order in which bowlers will throw ball
	 */
	public void orderOfBowler() {
		int toalBallsAvailable = 0;
		for (Bowler bowler : listOfBowler) {
			toalBallsAvailable += bowler.getNumberOfBalls();
		}
		/**
		 * check whether balls played by player is less than balls available
		 */
		if (toalBallsAvailable < ballsOfPlayer) {
			throw new AssertionError("balls not available");
		}

		Bowler obj;
		listOfBallsThrown = new ArrayList<Bowler>();
		for (int i = 0; i < ballsOfPlayer; i++) {
			obj = getMaximumBalls();

			if (i == 0) {

				listOfBallsThrown.add(new Bowler(obj.getName(), 1));
				obj.setNumberOfBalls(obj.getNumberOfBalls() - 1);
			}
			if (i != 0) {
				int size = listOfBallsThrown.size();
				if ((obj.getName()).equals(listOfBallsThrown.get(size - 1).getName())) {
					listOfBallsThrown.get(size - 1)
							.setNumberOfBalls(listOfBallsThrown.get(size - 1).getNumberOfBalls() + 1);
					obj.setNumberOfBalls(obj.getNumberOfBalls() - 1);
				} else {
					listOfBallsThrown.add(new Bowler(obj.getName(), 1));
					obj.setNumberOfBalls(obj.getNumberOfBalls() - 1);
				}
			}

		}

	}

	/**
	 * find the bowler left with maximum number of balls
	 * 
	 * @return bowler with maximum balls
	 */
	private Bowler getMaximumBalls() {
		Bowler obj = listOfBowler.get(0);
		for (int i = 1; i < listOfBowler.size(); i++) {
			if (obj.getNumberOfBalls() < listOfBowler.get(i).getNumberOfBalls()) {
				obj = listOfBowler.get(i);
			}
		}
		return obj;

	}

	/**
	 * @return list of bowler in which balls were thrown
	 */
	public List<Bowler> getBallThrownList() {
		return listOfBallsThrown;

	}

	/**
	 * display bowler with their name and number of balls thrown
	 */
	public void display() {
		for (int i = 0; i < listOfBallsThrown.size(); i++) {
			System.out.println(listOfBallsThrown.get(i).getName() + " " + listOfBallsThrown.get(i).getNumberOfBalls());
		}
	}

}
