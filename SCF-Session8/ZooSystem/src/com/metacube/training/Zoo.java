package com.metacube.training;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
	private int maxNoOfZones;
	private List<Zone> zoneList=new ArrayList<Zone>();
	/**
	 * default constructor
	 */
	public Zoo()
	{
		
	}
	
	/**
	 * parametrized constructor
	 * @param maxNoOfZones indicates maximum number of zones in zoo
	 */
	public Zoo(int maxNoOfZones)
	{
		this.maxNoOfZones=maxNoOfZones;
	}
	
	/**
	 * add zone in zoo
	 * @param zone is the zone to be added
	 * @return true if zone is added
	 */
	public boolean addZone(Zone zone)
	{   
		if(zoneList.size()<maxNoOfZones)
		{
			zoneList.add(zone);
			return true;
		}
		return false;
		
	}
	
	/**
	 * add cage
	 * @param cage  is the cage to be added
	 * @return true if cage is added
	 */
	public boolean addCage(Cage cage)
	{ 
		for(Zone zone:zoneList)
		{
			if(zone.getCategory()==cage.getCategory())
			{
				if(zone.addCage(cage))
				{
					return true;
				}
			}
		}
		return false;
		
	}
	

/**
 * add animal	
 * @param animal is the animal to be added
 * @return true if animal is added
 */
	public boolean addAnimal(Animal animal) {
        for (Zone zone : zoneList) {
            if (zone.getCategory() == animal.getCategory()) {
                if (zone.addAnimal(animal, zoneList.indexOf(zone))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}



