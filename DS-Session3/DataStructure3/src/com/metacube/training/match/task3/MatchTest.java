package com.metacube.training.match.task3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
public class MatchTest {

	@Test
	public void test() {
		List<Bowler> bowler=new ArrayList<Bowler>();
		Bowler b1=new Bowler("ram",7);
		Bowler b2=new Bowler("shyam",5);
		bowler.add(b1);
		bowler.add(b2);
		Match match=new Match(5,bowler);
		match.orderOfBowler();
		match.display();
		List<Bowler> expected=new ArrayList<Bowler>(){{add(new Bowler("ram",3));add(new Bowler("shyam",1));add(new Bowler("ram",1));}};
	}
	
	@Test (expected=AssertionError.class)
	public void test1() {
		List<Bowler> bowler=new ArrayList<Bowler>();
		Bowler b1=new Bowler("ram",7);
		Bowler b2=new Bowler("shyam",5);
		bowler.add(b1);
		bowler.add(b2);
		Match match=new Match(24,bowler);
		match.orderOfBowler();
		match.display();
		List<Bowler> expected=new ArrayList<Bowler>(){{add(new Bowler("ram",3));add(new Bowler("shyam",1));add(new Bowler("ram",1));}};
	}


}
