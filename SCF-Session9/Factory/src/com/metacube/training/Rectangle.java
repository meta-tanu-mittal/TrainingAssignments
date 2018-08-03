package com.metacube.training;

public class Rectangle implements Shape{
	int width;
	int height;
	Point point;
	/**
	 * default constructor
	 */
	public Rectangle()
	{
	}
	
	/**
	 * parametrized constructor
	 */
	public Rectangle(Point point ,int width,int height)
	{
		this.point=point;
		this.width=width;
		this.height=height;
	}
    
	/**
	 * find area
	 * @return area of rectangle
	 */
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width*height;
	}

	/**
	 * find perimeter
	 * @return perimeter of rectangle
	 */
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*(width+height);
	}
	
    /**
     * find origin point
     * @return origin point
     */
	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
		return point;
	}

	
	/**
	 * find if a point lie in rectangle or not
	 * @param x is x coordinate
	 * @param y is y coordinate
	 * @return true if point lie in rectangle
	 */
	@Override
	public boolean isPointEnclosed(int x, int y) {
		// TODO Auto-generated method stub
		boolean status=false;
		if(x>=point.getX()  &&  x<=point.getX()+width && y>=point.getY() && y<=point.getY()+height)
		{
			status=true;
		}
		
		return status;
	}

}
