package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.mappers.SkillMapper;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;


@Repository
public class SkillDAOImpl  implements SkillDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SkillDAOImpl(DataSource dataSource)
	{
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	private final String SQL_FIND_SKILL = "select * from skills_master where skill_id = ?";
	//private final String SQL_DELETE_SKILL = "delete from skills_master where skill_id = ?";
	private final String SQL_UPDATE_SKILL = "update skills_master set skill_name=? WHERE skill_id=?";
	private final String SQL_GET_ALL = "select * from skills_master";
	private final String SQL_INSERT_SKILL = "insert into skills_master(skill_name) values(?)";
    
	
	public Skill getSkillById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_SKILL, new Object[] { id }, new SkillMapper());
	}

	public List<Skill> getAllSkills() {
		return jdbcTemplate.query(SQL_GET_ALL, new SkillMapper());
	}

    public boolean createSkill(Skill skill)
    {
    	return jdbcTemplate.update(SQL_INSERT_SKILL, skill.getSkillName())>0;
    }
    
    public boolean updateSkill(Skill skill)
    {
    	return jdbcTemplate.update(SQL_UPDATE_SKILL,skill.getSkillName(),skill.getSkillId())>0;
    }



}
