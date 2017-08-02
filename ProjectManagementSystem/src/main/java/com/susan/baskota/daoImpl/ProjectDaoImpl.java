package com.susan.baskota.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.susan.baskota.dao.ProjectDao;
import com.susan.baskota.entity.Beneficary;
import com.susan.baskota.entity.Project;
import com.susan.baskota.entity.Resource;
import com.susan.baskota.entity.Task;
import com.susan.baskota.util.JpaUtil;

public class ProjectDaoImpl implements ProjectDao {

	public void createProject(Project project) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			// TODO your code
			em.persist(project);
			tx.commit();

		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}

	}

	public List<Project> createProjectList() {
		// TODO Auto-generated method stub

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<Project> projects = new ArrayList<Project>();
		System.out.println("<===========Project List============>");
		try {
			tx.begin();
			// TODO your code
			Query query = em.createQuery("from Project");
			projects = query.getResultList();
			for (Project project : projects) {
				System.out.println("Project Id: " + project.getId() + " Project Title: " + project.getTitle()
						+ " Project Location: " + project.getLocation() + " Project Startdate: "
						+ project.getStartDate() + " Project Enddate: " + project.getEndDate());

			}
			tx.commit();

		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
		return projects;
	}

	public List<Project> createProjectListWithBeneficaries() {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<Project> projects = new ArrayList<Project>();
		System.out.println("<===========Project List with Beneficaries============>");
		try {
			tx.begin();
			// TODO your code
			Query query = em.createQuery("from Project");
			projects = query.getResultList();
			for (Project project : projects) {
				System.out.println("Project Title:" + project.getTitle());
				for (Beneficary b : project.getBeneficaryList()) {
					System.out.println("Benficary:- " + b.getName());
				}
			}
			tx.commit();

		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
		return projects;
	}

	public List<Project> createProjectListWithStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Project> searchByResourceType(Resource resource) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Project> searchByProjectOrLocationKeyword(String keyword) {
		// TODO Auto-generated method stub
		System.out.println(keyword);
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<Project> projects = new ArrayList<Project>();
		System.out.println("<===========Search project by keywords============>");
		try {
			tx.begin();
			// TODO your code
			Query query = em
					.createQuery("Select p from Project p where p.title like :pattern or p.location like :pattern");
			String input = '%' + keyword + '%';
			System.out.println(input);
			query.setParameter("pattern", input);
			projects = query.getResultList();
			System.out.println("projects:" + projects);
			for (Project project : projects) {
				System.out.println("Project Title: " + project.getTitle() + " Project Location: "
						+ project.getLocation() + " Project Startdate: " + project.getStartDate() + " Project Enddate: "
						+ project.getEndDate());

			}
			tx.commit();

		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
		return projects;

	}

	@Override
	public void createProjectTasks(Task task) {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			// TODO your code
			em.persist(task);
			tx.commit();

		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
	}

	@Override
	public List<Project> createProjectTaskList() {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		List<Project> projects = new ArrayList<Project>();
		System.out.println("<===========Listing Tasks of the project============>");
		try {
			tx.begin();
			// TODO your code
			Query query = em.createQuery("from Project");
			projects = query.getResultList();
			for (Project project : projects) {
				System.out.println("Project Title: " + project.getTitle());
				for (Task task : project.getTaskList()) {
					System.out.println("Task Title: " + task.getDescription() + " Task Status: " + task.isStatus()
							+ " Task Resource: " + task.getResource() + " Task Startdate: " + task.getStartDate()
							+ " Task Enddate:" + task.getEndDate());
				}
			}
			tx.commit();

		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
		return projects;
	}

	@Override
	public Project getProjectById(int projectId) {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Project project = new Project();
		System.out.println("<===========Project Info============>");
		try {
			tx.begin();
			// TODO your code
//			Query query = em.createQuery("Select p from Project p where p.id like :pattern");
//			int input = '%' + projectId + '%';
//			System.out.println(input);
//			query.setParameter("pattern", input);
//			project = (Project) query.getSingleResult();
			project = em.find(Project.class, projectId);
				System.out.println("Project Title: " + project.getTitle() + " Project Location: "
						+ project.getLocation() + " Project Startdate: " + project.getStartDate() + " Project Enddate: "
						+ project.getEndDate());

			tx.commit();

		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
		return project;
}
}
