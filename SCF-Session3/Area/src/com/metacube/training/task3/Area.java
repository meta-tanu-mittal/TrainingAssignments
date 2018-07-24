package com.metacube.training.task3;

/**
 * Calculate Area 1 Triangle 2 Rectangle 3 Square 4 Circle
 * 
 * @author Tanu Mittal
 *
 */
public class Area {

	/**
	 * Calculate area of triangle
	 * 
	 * @param width
	 * @param height
	 * @return area of triangle
	 */
	double triangleArea(double width, double height) throws ArithmeticException {
		return (0.5 * width * height);
	}

	/**
	 * Calculate area of rectangle
	 * 
	 * @param height
	 * @param width
	 * @return area of triangle
	 */
	double rectangleArea(double height, double width) throws ArithmeticException {
		return (height * width);
	}

	/**
	 * Calculate area of square
	 * 
	 * @param width
	 * @return area of square
	 */
	double squareArea(double width) throws ArithmeticException {
		return (width * width);
	}

	/**
	 * Calculate area of circle
	 * 
	 * @param radius
	 * @return area of circle
	 */
	double areaCircle(double radius) throws ArithmeticException {
		return (22 * radius * radius) / 7;
	}

}
