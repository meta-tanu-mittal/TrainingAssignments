package com.dao;

import com.model.User;
import com.util.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UserDao {
	
	public boolean addUser(User user)
	{
		boolean inserted=false;
		String query=DBQueries.insertUser;
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,user.getFirstName());
			ps.setString(2,user.getLastName());
			ps.setDate(3, new Date(user.getDob().getTime()));
			ps.setString(4,user.getContact());
			ps.setString(5,user.getEmail());
			ps.setString(6,user.getPassword());
			ps.setString(7, user.getOrganization());
			
			if(ps.executeUpdate()>0)
			{
				inserted=true;
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return inserted;
	}
	
	
	
	public User isValidUser(String email,String password)
	{  
		User user=null;
		String query=DBQueries.loginQuery;
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet res=ps.executeQuery();
			System.out.println(res.getRow());

			if(res.next())
			{
				String firstName=res.getString("first_name");
				String lastName=res.getString("last_name");
				Date dob=res.getDate("dob");
				String contact=res.getString("contact");
				String organization=res.getString("organization");
				user=new User(firstName,lastName,dob,contact,email,password,organization);
				System.out.println(user.toString());
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
	public List<User> getAllFriend(String organization,String userEmail)
	{
     List<User> listOfUser = new ArrayList<User>();
     String query=DBQueries.friendListQuery;
     
     Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,organization);
			ResultSet res=ps.executeQuery();
			System.out.println(res.getRow());
            int i=0;
			while(res.next())
			{ 
				String email=res.getString("email");
				if(!(userEmail.equals(email)))
				{
				int id=res.getInt("id");
				String firstName=res.getString("first_name");
				String lastName=res.getString("last_name");
				Date dob=res.getDate("dob");
				String contact=res.getString("contact");
				String password=res.getString("password");
				listOfUser.add(new User(firstName,lastName,dob,contact,email,password,organization));
				System.out.println(listOfUser.get(i).toString());
				i++;
			}
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfUser;
	}

}
