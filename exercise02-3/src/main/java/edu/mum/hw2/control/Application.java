package edu.mum.hw2.control;

import javax.persistence.ElementCollection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.domain.Book;
import edu.mum.hw2.domain.CD;
import edu.mum.hw2.domain.DVD;
import edu.mum.hw2.domain.Product;


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
		
		Book book = em.find(Book.class, 1);
		CD cd = em.find(CD.class, 2);
		DVD dvd = em.find(DVD.class, 3);
		
		System.out.println("------ Book ------");
		System.out.println("Book Title : " + book.getTitle());
		System.out.println("Book Name : " + book.getName());
		
		System.out.println("------ CD ------");
		System.out.println("Artist : " + cd.getArtist());
		System.out.println("CD Name : " + cd.getName());
		
		System.out.println("------ DVD -----");
		System.out.println("Genre : " + dvd.getGenre());
		System.out.println("DVD Name : " + dvd.getName());
		
			tx.commit();
			
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
			System.out.println("ERROR!! printProductReport()");
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
			
			Book book = new Book();
			book.setName("EA Basics");
			book.setDescription("Enterprise Architecture 101");
			book.setTitle("EA101");
			
			CD cd = new CD();
			cd.setName("EA Basics CD");
			cd.setDescription("Enterprise Architecture 101 CD");
			cd.setArtist("Arrocha");
			
			DVD dvd = new DVD();
			dvd.setName("EA DE Videos");
			dvd.setDescription("Enterprise Architecture 101 Videos");
			dvd.setGenre("Text DVD");					
		
			em.persist(book);	
			em.persist(cd);
			em.persist(dvd);
			
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}

}
