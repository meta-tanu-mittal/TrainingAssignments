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
		// TODO Auto-generated method stub
		return width * width;
	}

	/**
	 * find peimeter of square
	 * 
	 * @return perimeter
	 */
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 4 * width;
	}

	/**
	 * check if point lie in square or not
	 * 
	 * @return true if point lie in square
	 */
	@Override
	public boolean isPointEnclosed(double x, double y) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return point;
	}

	/**
	 * @return shape type of class
	 */

	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return ShapeType.SQUARE;
	}

}
