package edu.mum.tvtube.DAO;

import java.util.List;

import javax.transaction.Transactional;

import edu.mum.tvtube.Domain.Episode;

public interface IEpisodeDAO {

	void create(Episode episode);

	void update(Episode episode);

	Episode findEpisode(int id);

	List<Episode> findAll();

	void delete(Episode episode);

}