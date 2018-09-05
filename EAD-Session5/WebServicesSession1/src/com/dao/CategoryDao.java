package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Category;
import com.util.DBConnection;

public class CategoryDao {
	
	public boolean addCategory(Category category)
	{   
		Connection con= DBConnection.getConnection();
		String query=CategoryQueries.ADD_CATEGORY;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,category.getName());
			if(ps.executeUpdate()>0)
			{
				return true;
			}
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
		
	}
	
	
	public List<Category> getAllCategory()
	{
	 List<Category> listOfCategory=new ArrayList<Category>();
	 Connection con= DBConnection.getConnection();
		String query=CategoryQueries.ALL_CATEGORY;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				int id=res.getInt("id");
				String name=res.getString("name");
				Category c=new Category(name);
				c.setId(id);
				listOfCategory.add(c);
			}
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
	return listOfCategory;
		
	}

}
