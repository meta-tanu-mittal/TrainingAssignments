package com.metacube.training.match.task3;

import java.util.ArrayList;
import java.util.List;
/**
 * Main class
 * @author Tanu Mittal
 *
 */
public class MatchMain {
	public static void main(String[] args) {
		List<Bowler> bowler=new ArrayList<Bowler>();
		Bowler b1=new Bowler("tanu",7);
		Bowler b2=new Bowler("kirti",5);
		Bowler b3=new Bowler("shanu",6);
		bowler.add(b1);
		bowler.add(b2);
		bowler.add(b3);
		Match match=new Match(10,bowler);
		match.orderOfBowler();
		match.display();
		
		
	}

}
