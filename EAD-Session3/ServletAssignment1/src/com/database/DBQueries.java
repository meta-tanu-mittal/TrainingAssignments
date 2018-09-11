package com.database;

public interface DBQueries {
	
	public static final String insertEmployee="INSERT INTO employee_detail(first_name,last_name,email,age) "
			+ "values(?,?,?,?)";
	
	public static final String searchEmployee="SELECT first_name,last_name,email,age "
			+ "FROM employee_detail "
			+ "WHERE first_name LIKE CONCAT('%',?,'%') OR last_name LIKE CONCAT('%',?,'%')";
	
	public static final String allEmployee="SELECT id,first_name,last_name,email,age "
			+ "FROM employee_detail ";
	
	public static final String updateEmployee="UPDATE employee_detail "
			+ "SET first_name=?, "
			+ "last_name=?, "
			+ "email=?, "
			+ "age=? "
			+ "WHERE id=?";
	
	public static final String searchById="SELECT first_name,last_name,email,age "
			+ "FROM employee_detail "
			+ "WHERE id=?";
	


}
