package com.metacube.training;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.metacube.training.Shape.ShapeType;

public class FactoryJUnitTest {

	@Test
	public void testSquare() {
		Shape shape = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		assertEquals(4, shape.getArea(), 0.001);
		assertEquals(8, shape.getPerimeter(), 0.001);
		assertEquals(true, shape.isPointEnclosed(1, 1));
	}

	@Test
	public void testRectangle() {
		Shape shape = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		assertEquals(12, shape.getArea(), 0.001);
		assertEquals(14, shape.getPerimeter(), 0.001);
		assertEquals(true, shape.isPointEnclosed(1, 1));
	}

	@Test
	public void testTriangle() {
		Shape shape = ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		assertEquals(0.5 * 3 * 4, shape.getArea(), 0.001);
		assertEquals(12, shape.getPerimeter(), 0.001);
		assertEquals(true, shape.isPointEnclosed(1, 1));
	}

	@Test
	public void testCircle() {
		Shape shape = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(5.0);
			}
		});
		assertEquals(Math.PI * 5 * 5, shape.getArea(), 0.001);
		assertEquals(2 * Math.PI * 5, shape.getPerimeter(), 0.001);
		assertEquals(true, shape.isPointEnclosed(2, 3));
	}

	@Test
	public void testAddShape() {
		Shape shape1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		Screen screen = new Screen();
		screen.addShape(shape1);
		screen.addShape(shape2);
		assertEquals(new ArrayList<Shape>() {
			{
				add(shape1);
				add(shape2);
			}
		}, screen.getShapeList());
	}

	@Test
	public void testDeleteShape() {
		Shape shape1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		Screen screen = new Screen();
		screen.addShape(shape1);
		screen.addShape(shape2);
		screen.deleteShape(shape2);
		assertEquals(new ArrayList<Shape>() {
			{
				add(shape1);
			}
		}, screen.getShapeList());
	}

	@Test
	public void testDeleteSameTypeShapes() {
		Shape shape1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		Shape shape3 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		Shape shape4 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		Screen screen = new Screen();
		screen.addShape(shape1);
		screen.addShape(shape2);
		screen.addShape(shape3);
		screen.addShape(shape4);
		screen.deleteSameTypeShapes(ShapeType.SQUARE);
		assertEquals(new ArrayList<Shape>() {
			{
				add(shape2);
			}
		}, screen.getShapeList());
	}

	@Test
	public void testSortByArea() {
		Shape shape1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		Shape shape3 = ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		Shape shape4 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(1.0);
			}
		});
		Screen screen = new Screen();
		screen.addShape(shape1);
		screen.addShape(shape2);
		screen.addShape(shape3);
		screen.addShape(shape4);
		screen.sortByArea();
		assertEquals(new ArrayList<Shape>() {
			{
				add(shape4);
				add(shape1);
				add(shape3);
				add(shape2);
			}
		}, screen.getShapeList());
	}

	@Test
	public void testSortByPerimeter() {
		Shape shape1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(2.0);
			}
		});
		Shape shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		Shape shape3 = ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(3.0);
				add(4.0);
			}
		});
		Shape shape4 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0, 0), new ArrayList<Double>() {
			{
				add(1.0);
			}
		});
		Screen screen = new Screen();
		screen.addShape(shape1);
		screen.addShape(shape2);
		screen.addShape(shape3);
		screen.addShape(shape4);
		screen.sortByPerimeter();
		assertEquals(new ArrayList<Shape>() {
			{
				add(shape4);
				add(shape1);
				add(shape3);
				add(shape2);
			}
		}, screen.getShapeList());
	}

}
