package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.model.Skill;
import com.metacube.training.util.DBConnection;

public class SkillDAOImpl {
	public  boolean  insertSkill(Skill skill) {
		String query = SkillQuery.INSERT_SKILL;
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, skill.getSkillName());
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
	
	public List<Skill> getAllSkill()
	{
		List<Skill> listOfSkill=new ArrayList<Skill>();
		String query = SkillQuery.GET_ALL_SKILL;
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				int id=res.getInt("skill_id");
				String name=res.getString("skill_name");
			    listOfSkill.add(new Skill(id,name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOfSkill;
		
	}
}