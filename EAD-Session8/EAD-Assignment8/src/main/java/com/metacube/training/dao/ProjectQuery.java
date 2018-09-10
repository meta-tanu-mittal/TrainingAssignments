package com.metacube.training.dao;

public interface ProjectQuery {
	String INSERT_PROJECT = "INSERT INTO project_master(name,description,start_date,end_date) VALUES(?,?,?,?)";

}
