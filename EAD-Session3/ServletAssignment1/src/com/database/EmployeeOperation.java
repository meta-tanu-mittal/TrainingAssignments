package com.database;
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;


public class EmployeeOperation {
	
	public boolean addEmployee(Employee employee)
	{    
		boolean inserted=false;
		String query=DBQueries.insertEmployee;
		
		Connection con=DBConnection.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, employee.getFirstName());
			ps.setString(2,employee.getLastName());
			ps.setString(3, employee.getEmail());
			ps.setInt(4, employee.getAge());
			
			if(ps.executeUpdate()>0)
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inserted;
	}
 
	public  List<Employee> searchEmployee(String firstName,String lastName)
	{
		List<Employee> employeeList=new ArrayList<Employee>();
		String query=DBQueries.searchEmployee;
        Connection con= DBConnection.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,firstName);
			ps.setString(2,lastName);
			ResultSet res=ps.executeQuery();
	
			while(res.next())
			{   String fName=res.getString("first_name");
			    String lName=res.getString("last_name");
				String email=res.getString("email");
				int age=res.getInt("age");
				//System.out.println(email+" "+age);
				employeeList.add(new Employee(fName,lName,email,age));
			}
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}
	
	public List<Employee> getAllEmployee()
	{
		List<Employee> listOfEmployee=new ArrayList<Employee>();
		String query=DBQueries.allEmployee;
        Connection con= DBConnection.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
	
			while(res.next())
			{   int id=res.getInt("id");
				String firstName=res.getString("first_name");
				String lastName=res.getString("last_name");
				String email=res.getString("email");
				int age=res.getInt("age");
				System.out.println(firstName+" "+lastName+" "+email+" "+age);
				Employee employee=new Employee(firstName,lastName,email,age);
				listOfEmployee.add(employee);
				employee.setId(id);
			}
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfEmployee;
	}
	
	
	public  boolean updateEmployee(Employee employee)
	{  
		boolean updated=false;
	   String query=DBQueries.updateEmployee;
	   Connection con= DBConnection.getConnection();
	
	try {
		PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, employee.getFirstName());
        ps.setString(2, employee.getLastName());
        ps.setString(3, employee.getEmail());
        ps.setInt(4, employee.getAge());
        ps.setInt(5, employee.getId());
        if(ps.executeUpdate()>0)
        {
        	updated=true;
        }
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return updated;	
	}
	
	public  Employee searchById(int id)
	{  
		//Employee employee = null;
	    String query=DBQueries.searchById;
	   Connection con= DBConnection.getConnection();
	
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, id);
        ResultSet res=ps.executeQuery();
        while(res.next())
        {
        String firstName=res.getString("first_name");
        String lastName=res.getString("last_name");
		String email=res.getString("email");
		int age=res.getInt("age");
		Employee employee=new Employee(firstName,lastName,email,age);
		employee.setId(id);
        
		return employee;
        }
	} catch (SQLException e) {
		e.printStackTrace();
	}
//		System.out.println(employee.toString());
		return null;
//		
	}
}
