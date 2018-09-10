package com.metacube.training.dao;

public interface SkillQuery {
	String INSERT_SKILL = "INSERT INTO skills_master(skill_name) VALUES(?)";
	String GET_ALL_SKILL = "SELECT * FROM skills_master";

}
