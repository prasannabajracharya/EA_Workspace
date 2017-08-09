package edu.mum.tvtube.DAO;

import java.util.List;

import javax.transaction.Transactional;

import edu.mum.tvtube.Domain.Tvseries;

public interface ITvseriesDAO {

	void create(Tvseries tvseries);

	void update(Tvseries tvseries);

	Tvseries findTvseries(int id);

	List<Tvseries> findAll();

	void delete(Tvseries tvseries);

}