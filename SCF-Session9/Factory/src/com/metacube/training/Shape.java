package com.metacube.training;

public interface Shape {
	public enum ShapeType
	{
		SQUARE,RECTANGLE,CIRCLE;
	}
	
	public double getArea();
	public double getPerimeter();
	public Point getOrigin();
	public boolean isPointEnclosed(int x,int y);

}
