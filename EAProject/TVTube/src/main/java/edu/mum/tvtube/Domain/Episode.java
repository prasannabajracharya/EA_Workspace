package edu.mum.tvtube.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Episode {

	@Id @GeneratedValue
	private int episodeId;
	private String description;
	private String director;
	private String episodeName;
	private String genre;
	@OneToMany
	private List<Cast> castList = new ArrayList<Cast>();
	
	public Episode(int episodeId, String description, String director, String episodeName, String genre,
			List<Cast> castList) {
		super();
		this.episodeId = episodeId;
		this.description = description;
		this.director = director;
		this.episodeName = episodeName;
		this.genre = genre;
		this.castList = castList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Cast> getCastList() {
		return castList;
	}

	public void setCastList(List<Cast> castList) {
		this.castList = castList;
	}
	
	
	
	
}
