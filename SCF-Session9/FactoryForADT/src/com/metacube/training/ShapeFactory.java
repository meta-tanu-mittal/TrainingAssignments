package com.metacube.training;

import java.util.List;

import com.metacube.training.Shape.ShapeType;

/**
 * create the objects of different type of shapes and return it
 * 
 * @author Tanu Mittal
 */
public class ShapeFactory {
	/**
	 * create object of shape
	 * 
	 * @param shapeType
	 *            define type of shape
	 * @param point
	 *            is an object of point class
	 * @param dimensions
	 *            is a list of dimensions
	 * @return object of shape
	 */
	public static Shape createShape(ShapeType shapeType, Point point, List<Double> dimensions) {
		Shape shape = null;
		switch (shapeType) {
		case RECTANGLE:
			shape = new Rectangle(point, dimensions.get(0), dimensions.get(1));
			break;
		case SQUARE:
			shape = new Square(point, dimensions.get(0));
			break;
		case CIRCLE:
			shape = new Circle(point, dimensions.get(0));
			break;
		case TRIANGLE:
			shape = new Triangle(point, dimensions.get(0), dimensions.get(1));
			break;
		default:
			break;

		}
		return shape;
	}

}
