package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.metacube.training.model.Project;
import com.metacube.training.util.DBConnection;

public class ProjectDAOImpl {
	public  boolean  insertProject(Project project) {
		System.out.println(project.getDescription()+" "+project.getName()+" "+project.getStartDate());
		String query = ProjectQuery.INSERT_PROJECT;
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, project.getName());
			ps.setString(2, project.getDescription());
			ps.setDate(3, (java.sql.Date) new Date( project.getStartDate().getTime()));
			ps.setDate(4,(java.sql.Date) new Date( project.getEndDate().getTime()));
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	

}
