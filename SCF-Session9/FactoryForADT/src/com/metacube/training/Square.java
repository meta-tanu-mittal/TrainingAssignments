package com.metacube.training;

/**
 * In square find 1 area 2 perimeter 3 origin 4 is point enclosed
 * 
 * @author user
 *
 */
public class Square implements Shape {
	private double width;
	private Point point;

	/**
	 * default constructor
	 */
	public Square() {

	}

	/**
	 * parametrized constructor
	 * 
	 * @param point
	 *            is an object of point class
	 * @param width
	 *            is width of square
	 */
	public Square(Point point, double width) {
		this.width = width;
		this.point = point;
	}

	/**
	 * find area of square
	 * 
	 * @return area
	 */
	@Override
	public double getArea() {
		return width * width;
	}

	/**
	 * find peimeter of square
	 * 
	 * @return perimeter
	 */
	@Override
	public double getPerimeter() {
		return 4 * width;
	}

	/**
	 * check if point lie in square or not
	 * 
	 * @return true if point lie in square
	 */
	@Override
	public boolean isPointEnclosed(double x, double y) {
		boolean status = false;
		if (x >= point.getX() && x <= point.getX() + width && y >= point.getY() && y <= point.getY() + width) {
			status = true;
		}

		return status;
	}

	/**
	 * find origin of square
	 * 
	 * @return points of origin
	 */
	@Override
	public Point getOrigin() {
		return point;
	}

	/**
	 * @return shape type of class
	 */

	@Override
	public ShapeType getShapeType() {
		return ShapeType.SQUARE;
	}

}
