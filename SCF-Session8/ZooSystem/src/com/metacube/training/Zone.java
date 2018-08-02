package com.metacube.training;

import java.util.ArrayList;
import java.util.List;

public class Zone {
	private int capacity;
	private AnimalCategory category;
	private List<Cage> cageList = new ArrayList<Cage>();

	/**
	 * default constructor
	 */
	public Zone() {

	}

	/**
	 * parametrized constructor
	 * 
	 * @param category
	 *            is category of animal
	 * @param capacity
	 *            is maximum number of zones
	 */
	public Zone(AnimalCategory category, int capacity) {
		this.category = category;
		this.capacity = capacity;
	}

	/**
	 * add cage to zone
	 * 
	 * @param cage
	 *            is an object of cage
	 * @return true if cage is added
	 */
	public boolean addCage(Cage cage) {
		if (cageList.size() < capacity) {
			cageList.add(cage);
			return true;
		}
		return false;

	}

	/**
	 * add animal
	 * 
	 * @param animal
	 *            is animal added to zone
	 * @param zone
	 *            is index of zone on which animal is added
	 * @return true if animal is added
	 */
	public boolean addAnimal(Animal animal, int zone) {
		for (Cage cage : cageList) {
			if (cage.getType() == animal.getType()) {
				if (cage.addAnimal(animal, zone, cageList.indexOf(cage))) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * @return capacity of zone
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return category of animal
	 */
	public AnimalCategory getCategory() {
		return category;
	}

	/**
	 * @return list of cages in zone
	 */

	public List<Cage> getCageList() {
		return cageList;
	}

}
