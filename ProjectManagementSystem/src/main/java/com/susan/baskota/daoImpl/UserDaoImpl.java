package com.susan.baskota.daoImpl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.susan.baskota.dao.UserDao;
import com.susan.baskota.entity.User;
import com.susan.baskota.util.JpaUtil;

public class UserDaoImpl implements UserDao {

	private static Scanner scanner = new Scanner(System.in);
	
	public void registerUser() {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			// TODO your code
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword("admin");
			
			User volunteer = new User();
			volunteer.setUsername("volunteer");
			volunteer.setPassword("volunteer");

			em.persist(admin);
			em.persist(volunteer);
			tx.commit();

		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
			System.out.println("hello");
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
	}
	
	public String validateUser(){
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		String valid_username = "error";
		
		System.out.println("<======Input the User Credentials.=====>");
		System.out.println("Username: ");
		String username = scanner.nextLine();
		System.out.println("Password: ");
		String password = scanner.nextLine();
		//scanner.close();
		try {
			tx.begin();
			// TODO your code
			Query query = em.createQuery("from User");
			List<User> users =  query.getResultList();
			
			for(User user : users){
				if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
					valid_username = username;
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
		return valid_username;
	}

}
