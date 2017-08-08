package edu.mum.tvtube.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tvtube.DAO.ISeasonDAO;
import edu.mum.tvtube.Domain.Season;

@Service
public class SeasonService {
	
	private ISeasonDAO seasonDAO;
	
	public SeasonService(){		
	}
	
	@Autowired
	public SeasonService(ISeasonDAO seasonDAO) {
		super();
		this.seasonDAO = seasonDAO;
	}	
	
	public void create(Season season){
		seasonDAO.create(season);
	}
	
	public List<Season> getAllSeasons(){
		return seasonDAO.findAll();
	}
	
	public void update(Season season){
		seasonDAO.update(season);
	}
	
	public Season findSeason(int id){
		return seasonDAO.findSeason(id);
	}
	
	public void delete(Season season){
		seasonDAO.delete(season);
	}
	
}
