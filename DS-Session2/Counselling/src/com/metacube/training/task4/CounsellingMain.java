package com.metacube.training.task4;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Main class
 * 
 * @author Tanu Mittal
 *
 */
public class CounsellingMain {

	public static void main(String[] args) throws RowsExceededException, WriteException, BiffException {
		Counselling obj = new Counselling();
		obj.readCollegeProgram();
		obj.readStudentData();
		obj.assignProgram();
		obj.writeDataInSheet();
	}

}
