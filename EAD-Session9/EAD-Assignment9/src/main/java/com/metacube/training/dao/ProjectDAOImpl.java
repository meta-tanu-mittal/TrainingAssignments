package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProjectDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_PROJECT = "select * from project_master where project_id = ?";
	private final String SQL_DELETE_PROJECT = "delete from project_master where project_id = ?";
	private final String SQL_UPDATE_PROJECT = "update project_master set name = ?, description = ?, start_date  = ?, end_date  = ? where project_id = ?";
	private final String SQL_GET_ALL = "select * from project_master";
	private final String SQL_INSERT_PROJECT = "insert into project_master(name, description, start_date, end_date) values(?,?,?,?)";

	public Project getProjectById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_PROJECT, new Object[] { id }, new ProjectMapper());
	}

	public List<Project> getAllProjects() {
		return jdbcTemplate.query(SQL_GET_ALL, new ProjectMapper());
	}

	public boolean deleteProject(Project project) {
		return jdbcTemplate.update(SQL_DELETE_PROJECT, project.getProjectId()) > 0;
	}

	public boolean updateProject(Project project) {
		return jdbcTemplate.update(SQL_UPDATE_PROJECT, project.getName(), project.getDescription(),
				project.getStartDate(), project.getEndDate(), project.getProjectId()) > 0;
	}

	public boolean createProject(Project project) {
		return jdbcTemplate.update(SQL_INSERT_PROJECT, project.getName(), project.getDescription(),
				project.getStartDate(), project.getEndDate()) > 0;
	}

}