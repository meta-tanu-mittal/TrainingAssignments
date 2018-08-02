package com.metacube.training.task1;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetJUnitTest {
  
	IntSet obj1 = new IntSet(new int[] { 2, 4, 6, 8, 1, 0, 1, 2, 3, 7 });
	IntSet obj2 = new IntSet(new int[] { 6, 8, 10 });
	
	@Test
	public void testIsMember() {
		assertEquals(true,obj1.isMember(2));
	}
    
	@Test
	public void testSize() {
		assertEquals(7,obj1.size());
	}
	
	@Test
	public void testIsSubset() {
		assertEquals(false,obj1.isSubset(obj2));
	}
	
	@Test
	public void testIsSubset1() {
		IntSet obj3 = new IntSet(new int[] { 6, 8, 2});
        assertEquals(true,obj1.isSubset(obj3));
	}
	
	@Test
	public void testUnion() {
		IntSet obj3=IntSet.union(obj1, obj2);
		assertArrayEquals(new int[]{2,4,6,8,1,3,7,10},obj3.getSetArray());
	}
	
	@Test
	public void testComplement() {
		IntSet obj5=new IntSet(new int[]{2,3});
		IntSet obj6=obj5.getComplement();
		int complementArray[]=obj6.getSetArray();
		assertEquals(998,complementArray.length);
	}
	
}
