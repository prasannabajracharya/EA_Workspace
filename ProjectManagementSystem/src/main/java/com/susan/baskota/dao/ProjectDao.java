package com.susan.baskota.dao;

import java.util.List;

import com.susan.baskota.entity.Project;
import com.susan.baskota.entity.Resource;
import com.susan.baskota.entity.Task;

public interface ProjectDao {

	//create Project
	void createProject(Project project);
	//list all project list
	List<Project> createProjectList();
	//list all projects with beneficaries
	List<Project> createProjectListWithBeneficaries(); 
	//list all project with status
	List<Project> createProjectListWithStatus();
	//search project by resorce type
	List<Project> searchByResourceType(Resource resource);
	//search project by keyword (like keyword)
	List<Project> searchByProjectOrLocationKeyword(String string);
	//create task of project
	void createProjectTasks(Task task);
	//list the project tasks
	List<Project> createProjectTaskList();
	//get Project by id
	Project getProjectById(int projectId);
}
