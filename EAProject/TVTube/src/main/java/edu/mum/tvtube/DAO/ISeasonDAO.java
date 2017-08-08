package edu.mum.tvtube.DAO;

import java.util.List;

import edu.mum.tvtube.Domain.Season;

public interface ISeasonDAO {

	void create(Season season);
	
	public void update(Season season);

	List<Season> findAll();
	
	public Season findSeason(int id);
	
	public void delete(Season season);
	
}