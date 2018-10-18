package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Project;

public interface ProjectDAO {

	
	/**
	 * find project by id
	 * @param id
	 * @return  project details
	 */
	Project getProjectById(int id);

	/**
	 * find list of all project
	 * @return list of project
	 */
	List<Project> getAllProjects();

	/**
	 * delete projct
	 * @param project
	 * @return true if project is eleted
	 */
	boolean deleteProject(Project project);

	/**
	 * update project details
	 * @param project
	 * @return true if project is updated
	 */
	boolean updateProject(Project project);

	/**
	 * create new project
	 * @param project
	 * @return true if project is created
	 */
	boolean createProject(Project project);
}
