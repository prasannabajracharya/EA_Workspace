package cs544.lab04_1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import cs544.lab04_1.model.Airline;
import cs544.lab04_1.model.Airplane;
import cs544.lab04_1.model.Airport;
import cs544.lab04_1.model.Flight;

public class App {
	private static Logger logger = Logger.getLogger(App.class);;

	private static final EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		EntityManager em = null;
		EntityTransaction tx = null;

		// fill the database
		fillDataBase();

		// Flights leaving USA capacity > 500
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			logger.trace("List all the flights:");
			 Query query = em.createQuery("Select f FROM Flight f JOIN f.origin f1 JOIN f.airplane f2 where f1.country = :contry and f2.capacity > 500");
			 query.setParameter("contry", "USA");
			 List<Flight> flights = query.getResultList();
			 logger.trace(String.format("%-9s%-31s%-31s", "Flight:", "Departs:",
					"Arrives:"));
			for (Flight flight : flights) {
				logger.trace(String.format(
						"%-7s  %-12s %7s %8s  %-12s %7s %8s",
						flight.getId(),
						flight.getFlightnr(), flight.getOrigin().getCity(),
						flight.getDepartureDate(), flight.getDepartureTime(),
						flight.getDestination().getCity(),
						flight.getArrivalDate(), flight.getArrivalTime()));
			}
			

			logger.trace("List all the airlines that use A380 (model) airplanes:");
			List<Airline> airlines = em.createQuery("SELECT a from Airline a join a.flights b join b.airplane c where c.model = 'A380'").getResultList();
			//logger.trace(String.format("%-9s%-31s", "AirlineID:", "AirlineName:"));
			for (Airline airline : airlines) {
				System.out.println(airline.getId() + " " + airline.getName());
				
			}
			
			logger.trace("All fights using 747 planes that don t belong to  Star Alliance :");
			List<Flight> flights747 = em.createQuery("select a from Flight a join a.airplane b join a.airline c where b.model = '747' and c.name <> 'Star Alliance'").getResultList();

			for (Flight flight : flights747) {
				logger.trace(String.format(
						"%-7s  %-12s %7s %8s  %-12s %7s %8s",
						flight.getId(),
						flight.getFlightnr(), flight.getOrigin().getCity(),
						flight.getDepartureDate(), flight.getDepartureTime(),
						flight.getDestination().getCity(),
						flight.getArrivalDate(), flight.getArrivalTime()));
			}
			
			logger.trace("All flights leaving before 12pm on 08/07/2009 :");
			List<Flight> flightsLeaving = em.createQuery("select a from Flight a where a.departureDate = '2009-08-07' and a.departureTime < '24:00:00'").getResultList();

			for (Flight flight : flightsLeaving) {
				logger.trace(String.format(
						"%-7s  %-12s %7s %8s  %-12s %7s %8s",
						flight.getId(),
						flight.getFlightnr(), flight.getOrigin().getCity(),
						flight.getDepartureDate(), flight.getDepartureTime(),
						flight.getDestination().getCity(),
						flight.getArrivalDate(), flight.getArrivalTime()));
			}
			
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {
				logger.error("Rolling back:", e);
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	public static void fillDataBase() {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {

			Airport mco = new Airport("MCO", "Orlando", "Florida", "USA");
			Airport mia = new Airport("MIA", "Miami", "Florida", "USA");

			Airplane airplane1 = new Airplane("56789", "A380", 519);

			Airline airline1 = new Airline("Delta");

			Flight flight1 = new Flight("DE 36", "08/06/2009", "7:10 pm",
					"06/25/2015", "9:00 am", airline1, mia, mco, airplane1);

			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.persist(flight1);

			tx.commit();
			
		} catch (PersistenceException e) {
			if (tx != null) {
				logger.error("Rolling back", e);
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
