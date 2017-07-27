package edu.mum.hw2.control;

import javax.persistence.ElementCollection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.jdbc.Blob;

import edu.mum.hw2.domain.Actor;
import edu.mum.hw2.domain.Movie;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

		addMovies();
		printMoviesReport();
		emf.close();
	}

	private static void printMoviesReport() {
		// TODO Auto-generated method stub
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			//code for report creation
			Movie movie = em.find(Movie.class,1);
			
			System.out.println("-------Movie Report--------");
			System.out.println("Movie Name: " + movie.getName());
			System.out.println("Movie Cover: " + movie.getImage());
			System.out.println("Movie Rating: " + movie.getRating());
			
			System.out.println("--------Actors----------");
			for(Actor actor: movie.getActors()){	
				System.out.println("   -" + actor.getName());
			}
			
			System.out.println("------ Movie Category -----");
			for(String category : movie.getCategories()){
				System.out.println(category);
			}
			
			System.out.println("------ Movie Comments -----");
			for(String comment : movie.getComments()){
				System.out.println(comment);
			}
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
			System.out.println("hello");
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}	
	}

	private static void addMovies() {
		byte[] fileData;
	
		Set<String> categories = new HashSet<String>();
		
		List<String> comments = new ArrayList<String>();
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

		// TODO your code
			Path p = FileSystems.getDefault().getPath("/Users/prasannabajracharya/Desktop/MUM/EA/EASTSWorkspace/exercise02-1/src/main/resources", "blob-clipart-10.jpg");

			 fileData = Files.readAllBytes(p);
	
			List<Actor> actors = new ArrayList<>();
			Actor actor1 = new Actor();
			
			actor1.setName("PrasannaMan");
			actor1.setRating(10);;
			actor1.setCharacter("Hero");
			
			Actor actor2 = new Actor();
			actor2.setName("ABCD");
			actor2.setRating(9);;
			actor2.setCharacter("SuperHero");
			
			actors.add(actor1);
			actors.add(actor2);
			
			Movie movie = new Movie();
			
			categories.add("Romantic");
			categories.add("Comedy");
			movie.setCategories(categories);
			
			comments.add("movie worth ticket price");
			comments.add("interesting movie");
			movie.setComments(comments);
			
			movie.setName("MyMovie");
			movie.setRating(10);
			movie.setImage(fileData);
			movie.setActors(actors);
			em.persist(movie);
			

			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}

}
