package edu.mum.tvtube.DAO;

import java.util.List;

import javax.transaction.Transactional;

import edu.mum.tvtube.Domain.Cast;

public interface ICastDAO {

	void create(Cast cast);
	
	public void update(Cast cast);

	List<Cast> findAll();
	
	public Cast findCast(int id);
	
	public void delete(Cast cast);
	
}