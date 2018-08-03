package com.metacube.training;

public class Square implements Shape {
	private int width;
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
	public Square(Point point, int width) {
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
	public boolean isPointEnclosed(int x, int y) {
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

}
