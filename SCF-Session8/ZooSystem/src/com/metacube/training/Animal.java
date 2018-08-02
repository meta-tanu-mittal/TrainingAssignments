package com.metacube.training;

public class Animal {
	private double age;
	private String sound;
	private String name;
	private AnimalType type;
	private AnimalCategory category;
	
	/** 
	 * default constructor
	 */
	public Animal()
	{
		
	}
	/**
	 * parametrized constructor of class
	 * @param name of animal 
	 * @param age of animal
	 * @param sound of animal
	 */
	public Animal(String name, double age,String sound)
	{
		this.name=name;
		this.age=age;
		this.sound=sound;
		
		switch(this.getClass().getSuperclass().getSimpleName())
		{
		case "Mammal":category=AnimalCategory.MAMMAL;
				break;
		case "Reptile":category=AnimalCategory.REPTILE;
			break;
		case "Bird":category=AnimalCategory.BIRD;
			break;
			default:throw new AssertionError("No such category exist");
		}
		
		switch(this.getClass().getSimpleName())
		{
		case "Lion":type=AnimalType.LION;
			break;
		case "Tiger":type=AnimalType.TIGER;
			break;
		case "Crocodile":type=AnimalType.CROCODILE;
			break;
		case "Peacock":type=AnimalType.PEACOCK;
			break;
			default:throw new AssertionError("No such Animal exist");
		}
	}
/**
 * @return age of animal
 */
	public double getAge() {
		return age;
	}

/**
 * @return sound of animal
 */
	public String getSound() {
		return sound;
	}
/**
 * @return name of animal
 */
   public String getName() {
		return name;
	}

   /**
    * @return animal type
    */
	public AnimalType getType() {
		return type;
	}

	/**
	 * @return category of animal
	 */
	public AnimalCategory getCategory() {
		return category;
	}
	
	/**
	 * @return null
	 */
	public String getInfo()
	{
		return null;
	}

}
