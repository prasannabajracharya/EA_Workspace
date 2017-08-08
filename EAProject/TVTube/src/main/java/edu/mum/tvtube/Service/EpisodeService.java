package edu.mum.tvtube.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.tvtube.DAO.ICastDAO;
import edu.mum.tvtube.DAO.IEpisodeDAO;
import edu.mum.tvtube.Domain.Cast;
import edu.mum.tvtube.Domain.Episode;

@Service
public class EpisodeService {
	
	private IEpisodeDAO episodeDAO;
	private ICastDAO castDAO;
	
	public EpisodeService(){		
	}
	
	@Autowired
	public EpisodeService(IEpisodeDAO episodeDAO) {
		super();
		this.episodeDAO = episodeDAO;
	}	
	
	public void create(Episode episode){
		episodeDAO.create(episode);
	}
	
	public List<Episode> getAllEpisodes(){
		return episodeDAO.findAll();
	}
	
	public void update(Episode episode){
		episodeDAO.update(episode);
	}
	
	public Episode findEpisode(int id){
		return episodeDAO.findEpisode(id);
	}
	
	public void delete(Episode episode){
		episodeDAO.delete(episode);
	}
	
	public List<Cast> getAllCasts(){
		return castDAO.findAll();
	}
}
