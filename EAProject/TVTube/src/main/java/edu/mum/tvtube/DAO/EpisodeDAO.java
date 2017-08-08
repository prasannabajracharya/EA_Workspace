package edu.mum.tvtube.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.tvtube.Domain.Episode;

@Repository
public class EpisodeDAO{
	
	private Session session;
	private static SessionFactory sessionFactory;
	
	public EpisodeDAO(){}
	
	@Autowired
	public EpisodeDAO(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Transactional
	public void create(Episode episode) {
		try {
			session = sessionFactory.getCurrentSession();
			//Transaction tx = session.beginTransaction();
			session.persist(episode);
			//tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in Episode DAO create.");
			e.printStackTrace();
		}
	}
	

	@Transactional
	public void update(Episode episode) {
			Session session = sessionFactory.getCurrentSession();
			session.update(episode);
	}


	@Transactional
	public Episode findEpisode(int id) {
		Session session = sessionFactory.getCurrentSession();		
		Episode episode = (Episode) session.get(Episode.class,id);
		return episode;
	}
	

	@Transactional
	public List<Episode> findAll() {
		session = sessionFactory.getCurrentSession();
		Query query = (Query) session.createQuery("select a from Episode a");
		return query.list();
	}


	@Transactional
	public void delete(Episode episode) {
		session = sessionFactory.getCurrentSession();
		session.delete(episode);		
	}

}
