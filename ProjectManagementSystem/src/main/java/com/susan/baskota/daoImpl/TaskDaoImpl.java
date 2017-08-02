package com.susan.baskota.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.susan.baskota.dao.TaskDao;
import com.susan.baskota.entity.Task;
import com.susan.baskota.util.JpaUtil;

public class TaskDaoImpl implements TaskDao {

	@Override
	public void createTask(Task task) {
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
	public void updateTask(Task task) {
		// TODO Auto-generated method stub
 
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			// TODO your code

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
	public void deleteTask(Task task) {
		// TODO Auto-generated method stub

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			// TODO your code
			em.remove(task);
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
	public void readTask() {
		// TODO Auto-generated method stub

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			// TODO your code
			//em.persist(project);
			tx.commit();

		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
	}

}
