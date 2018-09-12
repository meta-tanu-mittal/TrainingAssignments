package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet res, int arg1) throws SQLException {
		Employee employee=new Employee();
		employee.setEmpCode(res.getInt("emp_code"));
		employee.setFirstName(res.getString("first_name"));
		employee.setLastName(res.getString("last_name"));
		employee.setDob(res.getDate("dob"));
		employee.setGender(res.getString("gender"));
		employee.setPrimaryContactNo(res.getString("primary_contact_no"));
		employee.setSecondaryContactNo(res.getString("secondary_contact_no"));
		employee.setEmailId(res.getString("email_id"));
		employee.setSkypeId(res.getString("skype_id"));
		employee.setPassword(res.getString("password"));
		employee.setEnabled(res.getBoolean("enabled"));
		return employee;
	}

}
