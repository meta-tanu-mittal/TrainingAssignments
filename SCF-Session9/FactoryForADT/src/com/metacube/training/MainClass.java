package com.metacube.training;

import java.util.ArrayList;
import java.util.List;

import com.metacube.training.Shape.ShapeType;

public class MainClass {
	public static void main(String[] args) {
		Shape shape1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		Screen screen = new Screen();
		screen.addShape(shape1);

		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(2.0);
				add(3.0);
			}
		});
		screen.addShape(shape2);

		Shape shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(1.0);
			}
		});
		screen.addShape(shape3);

		Shape shape4 = ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(13.0);
				add(14.0);
			}
		});
		screen.addShape(shape4);

		System.out.println("shapes are:");
		screen.display();

	}

}
