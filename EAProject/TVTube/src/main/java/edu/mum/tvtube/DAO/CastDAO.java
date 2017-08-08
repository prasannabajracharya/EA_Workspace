package edu.mum.tvtube.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.tvtube.Domain.Cast;

@Repository
public class CastDAO implements ICastDAO {
	
	private Session session;
	private static SessionFactory sessionFactory;
	
	public CastDAO(){}
	
	@Autowired
	public CastDAO(SessionFactory sf){
		this.sessionFactory = sf;
	}

	/* (non-Javadoc)
	 * @see edu.mum.tvtube.DAO.ICastDAO#create(edu.mum.tvtube.Domain.Cast)
	 */
	@Override
	@Transactional
	public void create(Cast cast) {
		try {
			session = sessionFactory.getCurrentSession();
			//Transaction tx = session.beginTransaction();
			session.persist(cast);
			//tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in Cast DAO create.");
			e.printStackTrace();
		}
	}
	
	@Override
	@Transactional
	public void update(Cast cast) {
			Session session = sessionFactory.getCurrentSession();
			session.update(cast);
	}

	@Override
	@Transactional
	public Cast findCast(int id) {
		Session session = sessionFactory.getCurrentSession();		
		Cast cast = (Cast) session.get(Cast.class,id);
		return cast;
	}
	
	@Override
	@Transactional
	public List<Cast> findAll() {
		session = sessionFactory.getCurrentSession();
		Query query = (Query) session.createQuery("select a from Cast a");
		return query.list();
	}

	@Override
	@Transactional
	public void delete(Cast cast) {
		session = sessionFactory.getCurrentSession();
		session.delete(cast);		
	}

}
