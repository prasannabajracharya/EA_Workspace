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
public class EpisodeDAO implements IEpisodeDAO{
	
	private Session session;
	private static SessionFactory sessionFactory;
	
	public EpisodeDAO(){}
	
	@Autowired
	public EpisodeDAO(SessionFactory sf){
		this.sessionFactory = sf;
	}

	/* (non-Javadoc)
	 * @see edu.mum.tvtube.DAO.IEpisodeDAO#create(edu.mum.tvtube.Domain.Episode)
	 */
	@Override
	@Transactional
	public void create(Episode episode) {
		try {
			session = sessionFactory.getCurrentSession();
			session.persist(episode);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in Episode DAO create.");
			e.printStackTrace();
		}
	}	

	/* (non-Javadoc)
	 * @see edu.mum.tvtube.DAO.IEpisodeDAO#update(edu.mum.tvtube.Domain.Episode)
	 */
	@Override
	@Transactional
	public void update(Episode episode) {
			Session session = sessionFactory.getCurrentSession();
			session.update(episode);
	}

	/* (non-Javadoc)
	 * @see edu.mum.tvtube.DAO.IEpisodeDAO#findEpisode(int)
	 */
	@Override
	@Transactional
	public Episode findEpisode(int id) {
		Session session = sessionFactory.getCurrentSession();		
		Episode episode = (Episode) session.get(Episode.class,id);
		return episode;
	}	

	/* (non-Javadoc)
	 * @see edu.mum.tvtube.DAO.IEpisodeDAO#findAll()
	 */
	@Override
	@Transactional
	public List<Episode> findAll() {
		session = sessionFactory.getCurrentSession();
		Query query = (Query) session.createQuery("select a from Episode a");
		return query.list();
	}

	/* (non-Javadoc)
	 * @see edu.mum.tvtube.DAO.IEpisodeDAO#delete(edu.mum.tvtube.Domain.Episode)
	 */
	@Override
	@Transactional
	public void delete(Episode episode) {
		session = sessionFactory.getCurrentSession();
		session.delete(episode);		
	}

}
