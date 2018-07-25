package com.metacube.training.task1;
/**
 * In this set is created
 * @author Tanu Mittal
 *
 */
public final class IntSet {
	private final int setArray[];
	private int n = 0;

	/**
	 * this is constructor
	 * @param setArray 
	 */
	public IntSet(int[] setArray) {
		this.setArray = new int[setArray.length];
		for (int i = 0; i < setArray.length; i++) {
			if (setArray[i] > 0 && setArray[i] <= 1000 && !isMember(setArray[i])) {
				this.setArray[n] = setArray[i];
				n++;
			}
		}
	}
    
	/**
	 * find size of set
	 * @return size of set
	 */
	int size() {
		return n;
	}

	/**
	 * find whether givan value is member of set or not
	 * @param x  is value 
	 * @return true if is value of set, otherwise false
	 */
	boolean isMember(int x) {
		boolean status = false;
		for (int i = 0; i < size(); i++) {
			if (setArray[i] == x) {
				status = true;
				break;
			}
		}
		return status;
	}
  
	/**
	 * check whether given set is subset of set or not
	 * @param intSet is a set which is to checked
	 * @return true if subset otherwise false
	 */
	boolean isSubset(IntSet intSet) {
		boolean status = false;
		int count = 0;
		for (int i = 0; i < intSet.size(); i++) {
			for (int j = 0; j < size(); j++) {
				if (intSet.setArray[i] == setArray[j]) {
					count++;
					break;
				}
			}
		}
		if (count == intSet.size()) {
			status = true;
		}
		return status;
	}
 
	/**
	 * find the union of two sets
	 * @param obj1 is first set
	 * @param obj2 is second set
	 * @return union of sets
	 */
	public static IntSet union(IntSet obj1, IntSet obj2) {
		int[] unionOfSets = new int[obj1.size() + obj2.size()];
		int k = 0;
		for (int i = 0; i < obj1.size(); i++) {
			unionOfSets[k] = obj1.setArray[i];
			k++;
		}
		for (int i = 0; i < obj2.size(); i++) {
			if (!obj1.isMember(obj2.setArray[i])) {
				unionOfSets[k] = obj2.setArray[i];
				k++;
			}

		}
		return new IntSet(unionOfSets);
	}
 
	
	/**
	 * find complement of set
	 * @return complement of set
	 */ 
	
	IntSet getComplement() {
		int count=0;
		int tempArray[]=new int[1000];
		for(int i=0;i<1000;i++)
		{
			if(!isMember(i+1))
			{
				tempArray[count]=i+1;
				count++;
			}
		}
		int complementArray[]=new int[count];
		IntSet obj=new IntSet(complementArray);
		obj.n=count;
		return obj;
		
	}
	
  /**find set of array given 
   * 
   * @return array of values in set
   */
	int[] getSetArray() {
		int[] result=new int[size()];
		for(int i=0;i<size();i++)
		{
			result[i]=setArray[i];
		}
		return result;
	}
   
	/**
	 * display elements of set
	 */
	void display() {
		for (int i = 0; i < size(); i++) {
			System.out.print(setArray[i] + " ");
		}
	}

}
