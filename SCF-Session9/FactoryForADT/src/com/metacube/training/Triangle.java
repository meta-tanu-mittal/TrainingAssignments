package com.metacube.training;

/**
 * In Triangle find 1 area 2 perimeter 3 origin 4 is point enclosed
 * 
 * @author Tanu Mittal
 *
 */
public class Triangle implements Shape {
	private double base;
	private double height;
	private Point point;

	/**
	 * default constructor
	 */
	public Triangle() {

	}

	/**
	 * parametrized constructor
	 * 
	 * @param point
	 *            is an object of point class
	 * @param base
	 *            is base of triangle
	 * @param height
	 *            is height of triangle
	 */
	public Triangle(Point point, double base, double height) {
		this.point = point;
		this.height = height;
		this.base = base;
	}

	/**
	 * find area of triangle
	 * 
	 * @return area of triangle
	 */
	@Override
	public double getArea() {
		return 0.5 * height * base;
	}

	/**
	 * find perimeter of triangle
	 * 
	 * @return perimeter of triangle
	 */
	@Override
	public double getPerimeter() {
		double hypotenuse = Math.sqrt(Math.pow(height, 2) + Math.pow(base, 2));
		return height + base + hypotenuse;
	}

	/**
	 * find origin of triangle'
	 * 
	 * @return origin
	 */
	@Override
	public Point getOrigin() {
		return point;
	}

	/**
	 * find if the point is enclosed or not
	 * 
	 * @param x
	 *            is x coordinate
	 * @param y
	 *            is y coordinate
	 * @return true if point is enclosed
	 */
	@Override
	public boolean isPointEnclosed(double x, double y) {
		Point point1 = new Point(point.getX() + base, point.getY());
		Point point2 = new Point(point.getX(), point.getY() + height);
		double area1 = findAreaUsingPoints(x, y, point.getX(), point.getY(), point1.getX(), point1.getY());
		double area2 = findAreaUsingPoints(x, y, point.getX(), point.getY(), point2.getX(), point2.getY());
		double area3 = findAreaUsingPoints(x, y, point2.getX(), point2.getY(), point1.getX(), point1.getY());
		if (getArea() == (area1 + area2 + area3)) {
			return true;
		}
		return false;
	}

	/**
	 * find area of triangle using three coordinates
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @return area of triangle
	 */
	private double findAreaUsingPoints(double x1, double y1, double x2, double y2, double x3, double y3) {
		double area = 0.0;
		area = (Math.abs(((x1 * (y2 - y3)) + (x2 * (y3 - y1)) + (x3 * (y1 - y2)))) / 2.0);
		return area;
	}

	/**
	 * @return shape type of triangle class
	 */
	@Override
	public ShapeType getShapeType() {
		return ShapeType.TRIANGLE;
	}

}
