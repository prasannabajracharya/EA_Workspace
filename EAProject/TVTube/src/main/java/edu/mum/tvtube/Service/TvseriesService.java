package edu.mum.tvtube.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tvtube.DAO.ISeasonDAO;
import edu.mum.tvtube.DAO.ITvseriesDAO;
import edu.mum.tvtube.Domain.Season;
import edu.mum.tvtube.Domain.Tvseries;

@Service
public class TvseriesService {
	
	private ITvseriesDAO tvseriesDAO;
	private ISeasonDAO seasonDAO;
	
	public TvseriesService(){		
	}
	
	@Autowired
	public TvseriesService(ITvseriesDAO tvseriesDAO) {
		super();
		this.tvseriesDAO = tvseriesDAO;
	}	
	
	public void create(Tvseries tvseries){
		tvseriesDAO.create(tvseries);
	}
	
	public List<Tvseries> getAllTvseriess(){
		return tvseriesDAO.findAll();
	}
	
	public void update(Tvseries tvseries){
		tvseriesDAO.update(tvseries);
	}
	
	public Tvseries findTvseries(int id){
		return tvseriesDAO.findTvseries(id);
	}
	
	public void delete(Tvseries tvseries){
		tvseriesDAO.delete(tvseries);
	}
	
	public List<Season> getAllSeasons(){
		return seasonDAO.findAll();
	}
}
