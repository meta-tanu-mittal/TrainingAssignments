package com.metacube.training;

public class Circle implements Shape {

	int radius;
	Point point;
   /**
    * constructor
    * @param point is an object of point class
    * @param radius is radius of circle
    */
	public Circle(Point point, int radius) {
		this.radius = radius;
		this.point = point;
	}
   
	/**
	 * find area 
	 * @return area of circle
	 */
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (22 * radius * radius) / 7;
	}
   
	/**
	 * find perimeter
	 * @return perimeter of circle
	 */
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return (2 * 22 * radius) / 7;
	}

	/**
	 * find origin of circle
	 */
	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
		return null;
	}

    
	/**
	 * find whether these point lie in circle or not
	 * @param x is x coordinate
	 * @param y is y coordinate
	 * @return true is point lie in circle
	 */
	@Override
	public boolean isPointEnclosed(int x, int y) {
		// TODO Auto-generated method stub
		double distance;
		double xDifference = x - point.getX();
		double yDifference = y - point.getY();
		distance = Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2));
		if (distance <= radius) {
			return true;
		}
		return false;
	}

}
