package com.metacube.training;

import java.util.ArrayList;
import java.util.List;

import com.metacube.training.Shape.ShapeType;

public class MainClass {
	public static void main(String[] args) {
		List<Integer> lst=new ArrayList<Integer>();
		lst.add(2);
		lst.add(3);
		Shape shape1=FactoryClass.createShape(ShapeType.SQUARE, new Point(0,0), lst);
		Screen screen1=new Screen();
		screen1.addShape(shape1);
		
		Shape shape2=FactoryClass.createShape(ShapeType.RECTANGLE, new Point(0,0), lst);
		screen1.addShape(shape2);
	
		screen1.display();
	
		//System.out.println(shape.getArea());
	}

}
