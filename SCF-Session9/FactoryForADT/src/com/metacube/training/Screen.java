package com.metacube.training;

import java.util.ArrayList;
import java.util.List;

import com.metacube.training.Shape.ShapeType;

/**
 * on Screen 1 add shape 2 delete shape 3 delete shapes of same type 4 sort
 * shapes by area 5 sort shapes by perimeter
 * 
 * @author Tanu Mittal
 *
 */
public class Screen {
	private List<Shape> shapeList = new ArrayList<Shape>();

	/**
	 * add shape to shapeList
	 * 
	 * @param shape
	 *            is an object of shape class
	 */
	public void addShape(Shape shape) {
		shapeList.add(shape);
	}

	/**
	 * delete shape from list
	 * 
	 * @param shape
	 *            is an object of shape class
	 */
	public void deleteShape(Shape shape) {
		for (int i = 0; i < shapeList.size(); i++) {
			if (shapeList.get(i) == shape) {
				shapeList.remove(i);
				break;
			}
		}
	}

	/**
	 * delete all shapes of same type
	 * 
	 * @param shapeType
	 *            is a type of shape to be deleted
	 * 
	 */
	public void deleteSameTypeShapes(ShapeType shapeType) {

		for (int i = 0; i < shapeList.size(); i++) {
			if (shapeList.get(i).getShapeType() == shapeType) {
				shapeList.remove(i);
				i--;
			}
		}

	}

	/**
	 * sort shapes by area
	 * 
	 * @return sorted list
	 */
	public List<Shape> sortByArea() {
		List<Shape> sortedList = new ArrayList<>();
		sortedList = shapeList;
		for (int i = 0; i < sortedList.size(); i++) {
			for (int j = 0; j < sortedList.size() - i - 1; j++) {
				if (sortedList.get(j).getArea() > sortedList.get(j + 1).getArea()) {
					Shape temp = sortedList.get(j);
					sortedList.set(j, sortedList.get(j + 1));
					sortedList.set(j + 1, temp);
				}
			}
		}
		return sortedList;
	}

	/**
	 * sort shape by perimeter
	 * 
	 * @return sorted list
	 */
	public List<Shape> sortByPerimeter() {
		List<Shape> sortedList = new ArrayList<>();
		sortedList = shapeList;
		for (int i = 0; i < sortedList.size(); i++) {
			for (int j = 0; j < sortedList.size() - i - 1; j++) {
				if (sortedList.get(j).getPerimeter() > sortedList.get(j + 1).getPerimeter()) {
					Shape temp = sortedList.get(j);
					sortedList.set(j, sortedList.get(j + 1));
					sortedList.set(j + 1, temp);
				}
			}
		}
		return sortedList;
	}

	/**
	 * @return list of shapes
	 */
	public List<Shape> getShapeList() {
		return shapeList;
	}

	/**
	 * display all shapes
	 */
	public void display() {
		for (int i = 0; i < shapeList.size(); i++) {
			System.out.println(shapeList.get(i).getShapeType());
		}

	}

}
