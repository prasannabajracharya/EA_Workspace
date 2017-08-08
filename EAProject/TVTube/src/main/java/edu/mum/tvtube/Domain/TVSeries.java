package edu.mum.tvtube.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class TVSeries {
	@Id @GeneratedValue
	private int id;
	
	private String description;
	private String studio;
	private String director;
	private String name;
	private String genre;
	
	@OneToMany
	@JoinColumn(name="tvseriesId")
	private List<Season> seasonList = new ArrayList<Season>();

	public TVSeries(String description, String studio, String director, String name, String genre) {
		super();
		this.description = description;
		this.studio = studio;
		this.director = director;
		this.name = name;
		this.genre = genre;
	}
	

	
}
