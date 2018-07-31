package com.metacube.training;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Screen {
     private static Map<Shape,Date> shapeList=new HashMap<Shape,Date>();
     
     /**
      * add shape to shapeList
      * @param shape is an object of shape class
      */
	public void addShape(Shape shape)
	{
	   shapeList.put(shape, new Date()); 
	}
	
	/**
	 * delete shape from list
	 * @param shape is an object of shape class
	 */
	public void deleteShape(Shape shape)
	{
		if(shapeList.containsKey(shape))
		{
			shapeList.remove(shape);
		}
		else
		{
			throw new AssertionError("shape not deleted");
		}
	}
	
	/**
	 * delete all shapes of same type
	 * @param shape is a an object of shape to be deleted
	 */
	public void deleteSameTypeShapes(Shape shape)
	{
		for(int i=0;i<shapeList.size();i++)
		{
			if(shapeList.containsKey(shape))
			{
				shapeList.remove(shape);
			}
		}
	}
	
	/**
	 * display all shapes
	 */
	public void display()
	{
			System.out.println(shapeList.keySet());
	}
	
	
}
