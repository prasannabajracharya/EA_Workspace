package edu.mum.tvtube.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Tvseries {
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

	public Tvseries(){}
	
	public Tvseries(String description, String studio, String director, String name, String genre) {
		super();
		this.description = description;
		this.studio = studio;
		this.director = director;
		this.name = name;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Season> getSeasonList() {
		return seasonList;
	}

	public void setSeasonList(List<Season> seasonList) {
		this.seasonList = seasonList;
	}
	

	
}
