package com.metacube.training;

/**
 * In rectangle find 1 area 2 perimeter 3 origin 4 is point enclosed
 * 
 * @author Tanu Mittal
 *
 */
public class Rectangle implements Shape {
	private double width;
	private double height;
	private Point point;

	/**
	 * default constructor
	 */
	public Rectangle() {
	}

	/**
	 * parametrized constructor
	 * 
	 * @param point
	 *            is an object of point class
	 * @param width
	 *            is width of triangle
	 * @param height
	 *            is height of triangle
	 */
	public Rectangle(Point point, double width, double height) {
		this.point = point;
		this.width = width;
		this.height = height;
	}

	/**
	 * find area
	 * 
	 * @return area of rectangle
	 */
	@Override
	public double getArea() {
		return width * height;
	}

	/**
	 * find perimeter
	 * 
	 * @return perimeter of rectangle
	 */
	@Override
	public double getPerimeter() {
		return 2 * (width + height);
	}

	/**
	 * find origin point
	 * 
	 * @return origin point
	 */
	@Override
	public Point getOrigin() {
		return point;
	}

	/**
	 * find if a point lie in rectangle or not
	 * 
	 * @param x
	 *            is x coordinate
	 * @param y
	 *            is y coordinate
	 * @return true if point lie in rectangle
	 */
	@Override
	public boolean isPointEnclosed(double x, double y) {
		boolean status = false;
		if (x >= point.getX() && x <= point.getX() + width && y >= point.getY() && y <= point.getY() + height) {
			status = true;
		}

		return status;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.RECTANGLE;
	}

}
