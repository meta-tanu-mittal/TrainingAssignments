package com.metacube.training.area;

import static org.junit.Assert.*;

import org.junit.Test;

public class AreaJUnitTest {

	@Test
	public void testTriangleArea() {
		Area obj = new Area();
		double area = obj.triangleArea(3, 9);
		assertEquals(13.5, area, 0.001);
	}

	@Test
	public void testRectangleArea() {
		Area obj = new Area();
		double area = obj.rectangleArea(3.5, 3);
		assertEquals(10.5, area, 0.001);
	}

	@Test
	public void testSquareArea() {
		Area obj = new Area();
		double area = obj.squareArea(3.5);
		assertEquals(12.25, area, 0.001);
	}

	@Test
	public void testCircleArea() {
		Area obj = new Area();
		double area = obj.circleArea(3);
		assertEquals(28.285, area, 0.001);
	}

}
