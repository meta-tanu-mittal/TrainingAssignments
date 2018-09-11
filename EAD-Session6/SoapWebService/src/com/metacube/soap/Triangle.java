package com.metacube.soap;

public class Triangle {
	
	public double areaOfTriangle(double side1,double side2,double side3)
	{
	  double area=0.0;
	  double s=(side1+side2+side3)/2;
	  area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
	}

}
