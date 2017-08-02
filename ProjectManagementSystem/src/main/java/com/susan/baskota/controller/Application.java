package com.susan.baskota.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.susan.baskota.dao.ProjectDao;
import com.susan.baskota.dao.UserDao;
import com.susan.baskota.daoImpl.ProjectDaoImpl;
import com.susan.baskota.daoImpl.UserDaoImpl;
import com.susan.baskota.entity.Beneficary;
import com.susan.baskota.entity.Project;
import com.susan.baskota.entity.Resource;
import com.susan.baskota.entity.Task;

public class Application {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {	
		populateDB();
		registerUser();
		scanner.close();
	}
	
	public static void populateDB(){
		Project project = new Project();
		Beneficary student = new Beneficary();
		Beneficary faculty = new Beneficary();
		Beneficary staff = new Beneficary();
		
		student.setName("student");
		faculty.setName("faculty");
		staff.setName("staff");
		
		Task task1 = new Task();
		task1.setDescription("frontend work");
		task1.setStatus(true);
		task1.setResource(Resource.PROGRAMMER);
		task1.setStartDate(Date.valueOf("2017-01-01"));
		task1.setEndDate(Date.valueOf("2017-01-09"));
		
		Task task2 = new Task();
		task2.setDescription("backend work");
		task2.setStatus(false);
		task2.setResource(Resource.ENGINEER);
		task2.setStartDate(Date.valueOf("2017-01-01"));
		task2.setEndDate(Date.valueOf("2017-01-15"));
		
		project.setTitle("Library Management System");
		project.setLocation("fairfield");
		project.setStartDate(Date.valueOf("2017-01-01"));
		project.setEndDate(Date.valueOf("2017-02-01"));
		project.setBeneficaryList(Arrays.asList(student,faculty,staff));
		project.setTaskList(Arrays.asList(task1,task2));
		
		ProjectDao projectDao = new ProjectDaoImpl();
		projectDao.createProject(project);
	}
	
	public static void registerUser(){
		UserDao userDao = new UserDaoImpl();
		userDao.registerUser();
		String valid_user = userDao.validateUser();
		System.out.println("User Role: "+ valid_user.toUpperCase());	
		setUserRole(valid_user);
	}
	
	public static void setUserRole(String username) {
		// TODO Auto-generated method stub
		ProjectDao projectDao = new ProjectDaoImpl();
		if(username.equals("admin")){
			
			System.out.println("<------Enter 1 for viewing Project List------>");
			System.out.println("<------Enter 2 for Create New Project------>");
			System.out.println("<------Enter 3 for CRUD opeartion on Project task------>");
			int action = scanner.nextInt();
			
			if(action == 1){
				//retreive project list
				projectDao.createProjectList();
			}else if(action == 2){
				//create new project
				List<String> beneficaries = new ArrayList<String>();
				System.out.println("<=======Input Project Info==========>");
				System.out.println("Input title");
				String title = scanner.next();
				System.out.println("Input location");
				String location = scanner.next();
				System.out.println("Input start date(YYYY-MM-DD)");
				String startdate = scanner.next();
				System.out.println("Input end date(YYYY-MM-DD)");
				String enddate = scanner.next();
				
				System.out.println("Input beneficary list number");
				int n = scanner.nextInt();
				for(int i = 0; i < n; i++ ){
					System.out.println("Input "+i+ "st "+" beneficary name out of "+n);
					String beneifits = scanner.next();
					beneficaries.add(beneifits);
				}
				
				List<Beneficary> b = new ArrayList<Beneficary>();
				for(int i = 0; i < n; i++){
					b.add(new Beneficary(beneficaries.get(i)));
				}
				Project project = new Project();
				project.setTitle(title);
				project.setLocation(location);
				project.setStartDate(Date.valueOf(startdate));
				project.setEndDate(Date.valueOf(enddate));
				project.setBeneficaryList(b);
				
				projectDao.createProject(project);
				
			}else if(action == 3){
				//crud operation on tasks
				
				
			}
			else{
				//try again
				System.out.println("<======Try again=====>");
			}
		}
		else if(username.equals("volunteer")){
			
			System.out.println("<------Enter 1 for viewing project List and their beneficiary------>");
			System.out.println("<------Enter 2 for view project tasks------>");
			System.out.println("<------Enter 3 for view project list by status------>");
			System.out.println("<------Enter 4 for search project by type of resource------>");
			System.out.println("<------Enter 5 for search project by keyword or location------>");
			System.out.println("<------Enter 6 for List Projects that Volunteer has offered services------>");
			int action = scanner.nextInt();
			
			switch(action){
			case 1:
				projectDao.createProjectListWithBeneficaries();
				break;
			case 2:
				//first list project
				projectDao.createProjectList();
				//then ask for input of project id
				System.out.println("Input the Project ID");
				int id = scanner.nextInt();
				Project project = projectDao.getProjectById(id);
				//then ask CRUD for project tasks
				break;
			case 3: 
				projectDao.createProjectTaskList();
				break;
			case 4:
				
				break;
			case 5:
				System.out.println("<-----------Input Project title or location keyword to Search---------->");
				String keyword = scanner.next();
				projectDao.searchByProjectOrLocationKeyword(keyword);
				break;
			case 6:
				break;
			default:
				System.out.println("<=======Try again========>");
				
			}
		}
		else{
			System.out.println("<=====Incorrect User Credentials,Try again.=====>");
		}
	}

}
