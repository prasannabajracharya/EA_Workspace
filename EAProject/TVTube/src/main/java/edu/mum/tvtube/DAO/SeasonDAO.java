package edu.mum.tvtube.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.tvtube.Domain.Season;

@Repository
public class SeasonDAO implements ISeasonDAO {
	
	private Session session;
	private static SessionFactory sessionFactory;
	
	public SeasonDAO(){}
	
	@Autowired
	public SeasonDAO(SessionFactory sf){
		this.sessionFactory = sf;
	}

	/* (non-Javadoc)
	 * @see edu.mum.tvtube.DAO.ISeasonDAO#create(edu.mum.tvtube.Domain.Season)
	 */
	@Override
	@Transactional
	public void create(Season season) {
		try {
			session = sessionFactory.getCurrentSession();
			//Transaction tx = session.beginTransaction();
			session.persist(season);
			//tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in Season DAO create.");
			e.printStackTrace();
		}
	}
	
	@Override
	@Transactional
	public void update(Season season) {
			Session session = sessionFactory.getCurrentSession();
			session.update(season);
	}

	@Override
	@Transactional
	public Season findSeason(int id) {
		Session session = sessionFactory.getCurrentSession();		
		Season season = (Season) session.get(Season.class,id);
		return season;
	}
	
	@Override
	@Transactional
	public List<Season> findAll() {
		session = sessionFactory.getCurrentSession();
		Query query = (Query) session.createQuery("select a from Season a");
		return query.list();
	}

	@Override
	@Transactional
	public void delete(Season season) {
		session = sessionFactory.getCurrentSession();
		session.delete(season);		
	}

}
