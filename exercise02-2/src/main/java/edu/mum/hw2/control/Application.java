package edu.mum.hw2.control;

import javax.persistence.ElementCollection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.domain.Order;
import edu.mum.hw2.domain.OrderLine;
import edu.mum.hw2.domain.Product;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Application {

	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {

		addProduct();
		printProductReport();
		emf.close();
	}

	private static void printProductReport() {
		// TODO Auto-generated method stub
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			//code for report creation
			Product product = em.find(Product.class,1);
			
			System.out.println("-------product Report--------");
			System.out.println("product Name: " + product.getName());
			System.out.println("product Description: " + product.getDescription());

			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
			System.out.println("hello");
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}	
	}

	private static void addProduct() {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

		// TODO your code
			
			Product product = new Product();

			product.setName("Myproduct");
			product.setDescription("My Product Description");
			
			OrderLine orderline1 = new OrderLine();
			orderline1.setProduct(product);
			orderline1.setQuantity(10);
			
			OrderLine orderline2 = new OrderLine();
			orderline2.setProduct(product);
			orderline2.setQuantity(20);
			
			List<OrderLine> orderLine = new ArrayList<>();
			orderLine.add(orderline1);
			orderLine.add(orderline2);
			
			Order order = new Order();
			order.setOrderId(1);
			order.setDate(Date.valueOf("2017-01-10"));
			order.setOrderLine(orderLine);			
			

			em.persist(product);
			

			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}

}
