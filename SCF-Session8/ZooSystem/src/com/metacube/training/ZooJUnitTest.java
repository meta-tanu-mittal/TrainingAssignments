package com.metacube.training;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZooJUnitTest {

	Zoo zoo = new Zoo(2);

	@Test
	public void test() {

		Zone zone = new Zone(AnimalCategory.MAMMAL, 2);

		Cage cage = new Cage(AnimalCategory.MAMMAL, AnimalType.LION, 1);

		zoo.addZone(zone);
		zoo.addCage(cage);

		Animal lion = new Lion("lion1", 2, "roar");

		assertEquals(true, zoo.addAnimal(lion));

	}

	@Test
	public void test2() {

		Zone zone = new Zone(AnimalCategory.BIRD, 5);

		Cage cage = new Cage(AnimalCategory.BIRD, AnimalType.PEACOCK, 1);

		zoo.addZone(zone);
		zoo.addCage(cage);

		Animal peacock = new Peacock("peacock1", 25, "Cooko", 20);

		assertEquals(true, zoo.addAnimal(peacock));

	}

	@Test
	public void test3() {

		Zone zone = new Zone(AnimalCategory.REPTILE, 5);

		Cage cage = new Cage(AnimalCategory.REPTILE, AnimalType.CROCODILE, 1);

		zoo.addZone(zone);
		zoo.addCage(cage);

		Animal crocodile = new Crocodile("crocodile1", 2, "Cookdoo");

		assertEquals(true, zoo.addAnimal(crocodile));

	}

}
