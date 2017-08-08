package edu.mum.tvtube.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.tvtube.Domain.Tvseries;

@Repository
public class TvseriesDAO implements ITvseriesDAO{
	
	private Session session;
	private static SessionFactory sessionFactory;
	
	public TvseriesDAO(){}
	
	@Autowired
	public TvseriesDAO(SessionFactory sf){
		this.sessionFactory = sf;
	}

	/* (non-Javadoc)
	 * @see edu.mum.tvtube.DAO.ITvseriesDAO#create(edu.mum.tvtube.Domain.Tvseries)
	 */
	@Override
	@Transactional
	public void create(Tvseries tvseries) {
		try {
			session = sessionFactory.getCurrentSession();
			session.persist(tvseries);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in Tvseries DAO create.");
			e.printStackTrace();
		}
	}	

	/* (non-Javadoc)
	 * @see edu.mum.tvtube.DAO.ITvseriesDAO#update(edu.mum.tvtube.Domain.Tvseries)
	 */
	@Override
	@Transactional
	public void update(Tvseries tvseries) {
			Session session = sessionFactory.getCurrentSession();
			session.update(tvseries);
	}

	/* (non-Javadoc)
	 * @see edu.mum.tvtube.DAO.ITvseriesDAO#findTvseries(int)
	 */
	@Override
	@Transactional
	public Tvseries findTvseries(int id) {
		Session session = sessionFactory.getCurrentSession();		
		Tvseries tvseries = (Tvseries) session.get(Tvseries.class,id);
		return tvseries;
	}	

	/* (non-Javadoc)
	 * @see edu.mum.tvtube.DAO.ITvseriesDAO#findAll()
	 */
	@Override
	@Transactional
	public List<Tvseries> findAll() {
		session = sessionFactory.getCurrentSession();
		Query query = (Query) session.createQuery("select a from Tvseries a");
		return query.list();
	}

	/* (non-Javadoc)
	 * @see edu.mum.tvtube.DAO.ITvseriesDAO#delete(edu.mum.tvtube.Domain.Tvseries)
	 */
	@Override
	@Transactional
	public void delete(Tvseries tvseries) {
		session = sessionFactory.getCurrentSession();
		session.delete(tvseries);		
	}

}
