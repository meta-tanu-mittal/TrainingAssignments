package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.util.DBConnection;

public class EmployeeDAOImpl {
	
	public  boolean  insertEmployee(Employee employee) {
		String query = EmployeeQuery.INSERT_EMPLOYEE;
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setDate(3, new Date(employee.getDob().getTime()));
		    ps.setString(4, employee.getGender());
		    ps.setString(5, employee.getPrimaryContactNo());
		    ps.setString(6, employee.getSecondaryContactNo());
			ps.setString(7, employee.getEmailId());
			ps.setString(8, employee.getSkypeId());
			if(ps.executeUpdate()==1)
			{
				return true;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public List<Employee> getAllEmployee()
	{
		List<Employee> listOfEmployee=new ArrayList<Employee>();
		String query = EmployeeQuery.GET_ALL_EMPLOYEE;
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				int empCode=res.getInt("emp_code");
				String firstName=res.getString("first_name");
				String lastName=res.getString("last_name");
				Date dob=res.getDate("dob");
				String gender=res.getString("gender");
				String primaryContactNo=res.getString("primary_contact_no");
				String secondaryContactNo=res.getString("secondary_contact_no");
				String emailId=res.getString("email_id");
				String skypeId=res.getString("skype_id");
			    
				Employee employee=new Employee();
				employee.setEmpCode(empCode);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setDob(dob);
				employee.setGender(gender);
				employee.setPrimaryContactNo(primaryContactNo);
				employee.setSecondaryContactNo(secondaryContactNo);
				employee.setEmailId(emailId);
				employee.setSkypeId(skypeId);
				listOfEmployee.add(employee);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOfEmployee;
		
	}


	public Employee getEmployeeById(int empCode)
	{   
		Employee employee=new Employee();
		String query = EmployeeQuery.GET_EMPLOYEE_BY_ID;
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, empCode);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				String firstName=res.getString("first_name");
				String lastName=res.getString("last_name");
				Date dob=res.getDate("dob");
				String gender=res.getString("gender");
				String primaryContactNo=res.getString("primary_contact_no");
				String secondaryContactNo=res.getString("secondary_contact_no");
				String emailId=res.getString("email_id");
				String skypeId=res.getString("skype_id");
			    
				employee.setEmpCode(empCode);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setDob(dob);
				employee.setGender(gender);
				employee.setPrimaryContactNo(primaryContactNo);
				employee.setSecondaryContactNo(secondaryContactNo);
				employee.setEmailId(emailId);
				employee.setSkypeId(skypeId);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
		
	}
}
