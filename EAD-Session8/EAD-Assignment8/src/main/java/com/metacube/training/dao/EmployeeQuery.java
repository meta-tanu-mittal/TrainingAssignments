package com.metacube.training.dao;

public interface EmployeeQuery {
	
	String INSERT_EMPLOYEE="INSERT INTO employee(first_name,last_name,dob,gender,primary_contact_no,secondary_contact_no,email_id,skype_id) "
			+ "VALUES(?,?,?,?,?,?,?,?)";
	
	String GET_ALL_EMPLOYEE="SELECT * FROM employee";
	
	String GET_EMPLOYEE_BY_ID="SELECT * FROM employee WHERE emp_code=?";

}
