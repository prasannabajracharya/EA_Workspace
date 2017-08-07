package edu.mum.tvtube.DAO;

import java.util.List;

import javax.transaction.Transactional;

import edu.mum.tvtube.Domain.Cast;

public interface ICastDAO {

	void create(Cast cast);

	List<Cast> findAll();

}