package edu.mum.hw3.control;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw3.domain.Department;
import edu.mum.hw3.domain.Employee;
import edu.mum.hw3.domain.b.Book;
import edu.mum.hw3.domain.b.Publisher;
import edu.mum.hw3.domain.c.Course;
import edu.mum.hw3.domain.c.Student;
import edu.mum.hw3.domain.d.Customer;
import edu.mum.hw3.domain.d.Reservation;
import edu.mum.hw3.domain.f.Office;


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
			Employee emp1 = em.find(Employee.class, 2);
			Employee emp2 = em.find(Employee.class, 3);
			
			System.out.println("------- Dempartment Employee Report--------");
			System.out.println("Department Name: " + department.getName());
			System.out.println("Employee Name: " + emp1.getName());
			System.out.println("Employee Name: " + emp2.getName());
			
			Book book = em.find(Book.class, 4);
			
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
			emp1.setDepartment(department);
			emp2.setDepartment(department);
			
			//Bidirectional ManyToOne Emp<=> Office
			Office office = new Office();
			office.setBuilding("Argiro");
			office.setRoomNumber("R101");
			
			emp1.setOffice(office);
			emp2.setOffice(office);
			
			employees.add(emp1);
			employees.add(emp2);
			
			office.setEmpList(employees);
			
			em.persist(office);
					
			department.setEmployee(employees);
						
			em.persist(department);
			//em.persist(emp1); //no need as cascaded in department entity
			//em.persist(emp2);
			
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
			
			//ManyToMany Bidirectional
			
			Student stud1 = new Student();
			stud1.setFirstName("Prasanna");
			stud1.setLastName("Bajracharya");
			
			Student stud2 = new Student();
			stud2.setFirstName("Shyam");
			stud2.setLastName("Karki");
			
			Course course1 = new Course();
			course1.setCourseName("MyEA");
			course1.setCourseNumber("CS544");
			
			Course course2 = new Course();
			course2.setCourseName("MyEA2");
			course2.setCourseNumber("CS5442");
			
			List<Course> courseList = new ArrayList<Course>();
			courseList.add(course1);
			courseList.add(course2);
			
			List<Student> studentList = new ArrayList<Student>();
			studentList.add(stud1);
			studentList.add(stud2);
			
			//course1.setStudentList(studentList);
			stud1.setCourseList(courseList);
			stud2.setCourseList(courseList);
			
			em.persist(course1);
			em.persist(stud1);
			em.persist(course2);
			em.persist(stud2);
			
			// Unidirectional OneToMany
			Customer customer = new Customer();
			customer.setName("MyCustomer");
			
			Reservation reservation1 = new Reservation();
			reservation1.setDate(Date.valueOf("2017-12-12"));
			
			Reservation reservation2 = new Reservation();
			reservation2.setDate(Date.valueOf("2017-10-10"));
			
			customer.setReservationList(Arrays.asList(reservation1, reservation2));
			
			//Unidirectional ManyToOne Reservation To Book
			reservation1.setBook(book);
			reservation2.setBook(book);
			
			em.persist(customer);
			
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}

}
