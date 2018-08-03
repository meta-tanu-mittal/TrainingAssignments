package com.metacube.training;

public interface Shape {
	public enum ShapeType {
		SQUARE, RECTANGLE, CIRCLE, TRIANGLE;
	}

	public double getArea();

	public double getPerimeter();

	public Point getOrigin();

	public boolean isPointEnclosed(double x, double y);

	public ShapeType getShapeType();

}
