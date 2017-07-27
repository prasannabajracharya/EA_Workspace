package edu.mum.hw3.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw3.domain.Book;
import edu.mum.hw3.domain.Department;
import edu.mum.hw3.domain.Employee;
import edu.mum.hw3.domain.Publisher;


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

		addToDB();
		printReport();
		emf.close();
	}

	private static void printReport() {
		// TODO Auto-generated method stub
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			//code for report creation
			Department department = em.find(Department.class,1);
			Employee employee = em.find(Employee.class, 2);
			
			System.out.println("------- Dempartment Employee Report--------");
			System.out.println("Department Name: " + department.getName());
			System.out.println("Employee Name: " + employee.getName());
			
			Book book = em.find(Book.class, 3);
			
			System.out.println("------- Book Publisher Report--------");
			System.out.println("Book iSBN : " + book.getISBN());
			System.out.println("Book Title : " + book.getTitle());
			System.out.println("Book Author : " + book.getAuthor());
			System.out.println("Book Publisher Name : " + book.getPublisher().getName());

			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
			System.out.println("hello");
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}	
	}

	private static void addToDB() {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

		// TODO your code
			
			// Bidirectional OneToMany 
			Department department = new Department();			
			department.setName("Operations");

			List<Employee> employees = new ArrayList<Employee>();
			
			Employee emp1 = new Employee();
			emp1.setName("John");
			Employee emp2 = new Employee();
			emp2.setName("Adam");
			
			employees.add(emp1);
			employees.add(emp2);
			
			department.setEmployee(employees);
						
			em.persist(department);
	//		em.persist(employees);
			
			//Optional Unidirectional ManyToOne 
			Book book = new Book();
			book.setISBN("My iSBN");
			book.setTitle("My title");
			book.setAuthor("My author");
			
			Publisher publisher = new Publisher();
			publisher.setName("My publisher");
			book.setPublisher(publisher);
			
			em.persist(book);
			em.persist(publisher);
			
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}

}
