package com.metacube.training.task4;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import com.metacube.training.Queue.QueueUsingLinkList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;

/**
 * In this program is assigned to a students
 * 
 * @author Tanu Mittal
 *
 */
public class Counselling {
	private List<CollegeProgram> listOfCollegeProgram;
	private QueueUsingLinkList<Student> listOfStudent;
	private List<AllocatedProgram> listOfAllocatedProgram;

	/**
	 * constructor
	 */
	public Counselling() {
		listOfCollegeProgram = new ArrayList<CollegeProgram>();
		listOfStudent = new QueueUsingLinkList<Student>();
		listOfAllocatedProgram = new ArrayList<AllocatedProgram>();

	}

	/**
	 * read programs available from excel sheet
	 */
	public void readCollegeProgram() {
		String name;
		int capacity;

		try {

			Workbook workbook = Workbook.getWorkbook(new File("CollegeData.xls"));

			Sheet sheet1 = workbook.getSheet(0);
			int rows = sheet1.getRows();

			for (int i = 0; i < rows; i++) {
				name = sheet1.getCell(0, i).getContents();
				capacity = Integer.parseInt(sheet1.getCell(1, i).getContents());
				listOfCollegeProgram.add(new CollegeProgram(name, capacity));
			}

		} catch (BiffException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	/**
	 * read name of student and their preferences from excel sheet
	 */
	public void readStudentData() {
		String studentName;
		String[] choices;

		try {

			Workbook workbook = Workbook.getWorkbook(new File("StudentData.xls"));

			Sheet sheet1 = workbook.getSheet(0);
			int rows = sheet1.getRows();

			for (int i = 0; i < rows; i++) {
				studentName = sheet1.getCell(0, i).getContents();
				choices = new String[5];
				choices[0] = sheet1.getCell(1, i).getContents();
				choices[1] = sheet1.getCell(2, i).getContents();
				choices[2] = sheet1.getCell(3, i).getContents();
				choices[3] = sheet1.getCell(4, i).getContents();
				choices[4] = sheet1.getCell(5, i).getContents();
				listOfStudent.addItem(new Student(studentName, choices));
			}

		} catch (BiffException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	/**
	 * assign particular program to student according to their rank
	 */
	public void assignProgram() {
		while (!(listOfStudent.isEmpty())) {
			Student s = listOfStudent.pop();
			String preferences[] = s.getListOfChoices();
			String name = s.getName();

			loop: for (int i = 0; i < preferences.length; i++) {
				for (int j = 0; j < listOfCollegeProgram.size(); j++) {
					if (listOfCollegeProgram.get(j).getProgramName().equals(preferences[i])) {
						if (listOfCollegeProgram.get(j).getCapacity() > 0) {
							listOfCollegeProgram.get(j).setCapacity(listOfCollegeProgram.get(j).getCapacity() - 1);
							listOfAllocatedProgram.add(new AllocatedProgram(name, preferences[i]));
							break loop;
						}
					}
				}
			}
		}

		for (int i = 0; i < listOfAllocatedProgram.size(); i++) {
			System.out.println(
					listOfAllocatedProgram.get(i).getName() + " " + listOfAllocatedProgram.get(i).getProgram());
		}
	}

	/**
	 * write program Allocated to student in excel sheet
	 * 
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws BiffException
	 */
	public void writeDataInSheet() throws RowsExceededException, WriteException, BiffException {

		try {

			WritableWorkbook workbook = Workbook.createWorkbook(new File("ProgramAllocation.xls"));

			Sheet sheet = workbook.createSheet("firstSheet", 0);
			for (int i = 0; i < listOfAllocatedProgram.size(); i++) {
				Label label1 = new Label(0, i, listOfAllocatedProgram.get(i).getName());
				((WritableSheet) sheet).addCell(label1);

				Label label2 = new Label(1, i, listOfAllocatedProgram.get(i).getProgram());
				((WritableSheet) sheet).addCell(label2);
			}
			workbook.write();
			workbook.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
