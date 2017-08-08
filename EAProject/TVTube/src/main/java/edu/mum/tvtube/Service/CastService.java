package edu.mum.tvtube.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.tvtube.DAO.ICastDAO;
import edu.mum.tvtube.Domain.Cast;

public class CastService {
	
	private ICastDAO castDAO;
	
	public CastService(){		
	}
	
	@Autowired
	public CastService(ICastDAO castDAO) {
		super();
		this.castDAO = castDAO;
	}	
	
	public void create(Cast cast){
		castDAO.create(cast);
	}
	
	public List<Cast> getAllCasts(){
		return castDAO.findAll();
	}
	
	public void update(Cast cast){
		castDAO.update(cast);
	}
	
	public Cast findCast(int id){
		return castDAO.findCast(id);
	}
	
	public void delete(Cast cast){
		castDAO.delete(cast);
	}
	
}
