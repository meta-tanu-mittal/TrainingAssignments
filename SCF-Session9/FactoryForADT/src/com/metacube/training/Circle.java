package com.metacube.training;

/**
 * In circle find 1 area 2 peimeter 3 origin 4 is point enclosed
 * 
 * @author Tanu Mittal
 *
 */
public class Circle implements Shape {

	private double radius;
	private Point centrePoint;

	/**
	 * default constructor
	 */
	public Circle() {
	}

	/**
	 * parametrized constructor
	 * 
	 * @param point
	 *            is an object of point class
	 * @param radius
	 *            is radius of circle
	 */
	public Circle(Point point, double radius) {
		this.radius = radius;
		this.centrePoint = point;
	}

	/**
	 * find area
	 * 
	 * @return area of circle
	 */
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (Math.PI * radius * radius);
	}

	/**
	 * find perimeter
	 * 
	 * @return perimeter of circle
	 */
	@Override
	public double getPerimeter() {
		return (2 * Math.PI * radius);
	}

	/**
	 * find origin of circle
	 * 
	 * @@return leftmost point of circle
	 */
	@Override
	public Point getOrigin() {
		double slope = centrePoint.getY() / centrePoint.getX();
		double A = Math.pow(slope, 2) + 1;
		double B = -2 * ((slope * centrePoint.getY()) + centrePoint.getX());
		double C = (Math.pow(centrePoint.getY(), 2) + Math.pow(centrePoint.getX(), 2) - Math.pow(radius, 2));
		double underRoot = Math.sqrt(Math.pow(B, 2) - (4 * A * C));
		double firstX = (-B + underRoot) / (2 * A);
		double secondX = (-B - underRoot) / (2 * A);
		double valueOfY;
		if (firstX <= centrePoint.getX()) {
			valueOfY = slope * firstX;
			return new Point(firstX, valueOfY);
		} else {
			valueOfY = slope * secondX;
			return new Point(secondX, valueOfY);
		}

	}

	/**
	 * find whether these point lie in circle or not
	 * 
	 * @param x
	 *            is x coordinate
	 * @param y
	 *            is y coordinate
	 * @return true is point lie in circle
	 */
	@Override
	public boolean isPointEnclosed(double x, double y) {
		double distance;
		double xDifference = x - centrePoint.getX();
		double yDifference = y - centrePoint.getY();
		distance = Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2));
		if (distance <= radius) {
			return true;
		}
		return false;
	}

	/**
	 * @return shape type of circle
	 */
	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return ShapeType.CIRCLE;
	}

}
