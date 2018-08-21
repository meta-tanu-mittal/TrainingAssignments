package com.metacube.training.jdbc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JDBCTest {

	@Test
	public void testGetAllorders() {
		FetchData obj = new FetchData();
		assertEquals(1, obj.getAllOrders(3).size());
	}

	@Test
	public void testChangeProductStatus() {
		FetchData obj = new FetchData();
		assertEquals(4, obj.changeProductStatus());
	}

	 @Test
	 public void testInsertImageInBatch() {
	 FetchData obj=new FetchData();
	 List<Image> listOfImage=new ArrayList<Image>();
	 Image i1=new Image("image1","https://image1",2);
	 Image i2=new Image("image2","https://image2",2);
	 Image i3=new Image("image3","https://ismage3",2);
	 Image i4=new Image("image4","https://image4",2);
	 listOfImage.add(i1);
	 listOfImage.add(i2);
	 listOfImage.add(i3);
	 listOfImage.add(i4);
	 assertEquals(4,obj.insertImageInBatch(listOfImage));
	 }

	@Test
	public void testParentAndChild() {
		FetchData obj = new FetchData();
		List<ParentAndChild> result = obj.findTopCategoryAndChild();
		List<ParentAndChild> expected = new ArrayList<ParentAndChild>();
		expected.add(new ParentAndChild("electronic appliances", 3));
		expected.add(new ParentAndChild("home and furniture", 1));

		for (int i = 0; i < result.size(); i++) {
			assertEquals(expected.get(i).getName(), result.get(i).getName());
			assertEquals(expected.get(i).getNoOfChild(), result.get(i).getNoOfChild());
		}
	}

}
