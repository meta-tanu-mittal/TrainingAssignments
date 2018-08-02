package com.metacube.training;

import java.util.ArrayList;
import java.util.List;

public class Cage {
	private int capacity;
	private List<Animal> animalList = new ArrayList<Animal>();
	private AnimalCategory category;
	private AnimalType type;

	/**
	 * default constructor
	 */
	public Cage() {

	}

	/**
	 * parametrized constructor
	 * 
	 * @param category
	 *            is category of animal
	 * @param type
	 *            is type of animal
	 * @param capacity
	 *            is capacity of number of animals in cage
	 */
	public Cage(AnimalCategory category, AnimalType type, int capacity) {
		this.capacity = capacity;
		this.category = category;
		this.type = type;
	}

	/**
	 * add animal
	 * 
	 * @param animal
	 *            is object of animal
	 * @param zone
	 *            is zone in which element is added
	 * @param i
	 *            is index of zone
	 * @return true if animal added to cage
	 */
	public boolean addAnimal(Animal animal, int zone, int i) {
		if (getType() == animal.getType()) {
			if (animalList.size() < capacity) {
				animalList.add(animal);
				return true;
			} else {
				System.out.println("Cage has reached it's limit. Can not add animal.");
				return false;
			}

		} else {
			System.out.println("Can not add the animal to this category of cage.");
			return false;
		}
	}

	/**
	 * @return capacity of cage
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @return list of animals stored in cage
	 */
	public List<Animal> getAnimalList() {
		return animalList;
	}

	/**
	 * @return category of animal stored in cage
	 */
	public AnimalCategory getCategory() {
		return category;
	}

	/**
	 * @return type of animal
	 */
	public AnimalType getType() {
		return type;
	}

}
