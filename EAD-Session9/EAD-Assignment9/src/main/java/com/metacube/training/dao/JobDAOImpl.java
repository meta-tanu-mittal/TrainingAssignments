package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.JobMapper;
import com.metacube.training.model.Job;

@Repository
public class JobDAOImpl implements JobDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JobDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_JOB_BY_ID = "select * from job_title_master where job_code = ?";
	private final String SQL_UPDATE_JOB = "update job_title_master set job_title=? WHERE job_code=?";
	private final String SQL_GET_ALL_JOB = "select * from job_title_master";
	private final String SQL_INSERT_JOB = "insert into job_title_master(job_title) values(?)";

	@Override
	public Job getJobTitleById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_JOB_BY_ID, new Object[] { id }, new JobMapper());
	}

	@Override
	public List<Job> getAllJobTitle() {
		return jdbcTemplate.query(SQL_GET_ALL_JOB, new JobMapper());
	}

	@Override
	public boolean updateJobTitle(Job jobTitle) {
		return jdbcTemplate.update(SQL_UPDATE_JOB, jobTitle.getJobTitle(), jobTitle.getJobCode()) > 0;
	}

	@Override
	public boolean insertJobTitle(Job jobTitle) {
		return jdbcTemplate.update(SQL_INSERT_JOB, jobTitle.getJobTitle()) > 0;
	}

}
