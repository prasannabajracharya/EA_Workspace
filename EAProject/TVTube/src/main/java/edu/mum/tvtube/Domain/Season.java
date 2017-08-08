package edu.mum.tvtube.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Season {
	@Id @GeneratedValue
	private int id;
	@Lob
	@Column(columnDefinition="mediumBlob")
	private byte[] poster;
	
	private String summary;
	private String year;
	
	@OneToMany
	@JoinColumn(name="seasonId")
	private List<Episode> episodeList = new ArrayList<Episode>();

	public Season(){}
	
	public Season(byte[] poster, String summary, String year) {
		super();
		this.poster = poster;
		this.summary = summary;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getPoster() {
		return poster;
	}

	public void setPoster(byte[] poster) {
		this.poster = poster;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Episode> getEpisodeList() {
		return episodeList;
	}

	public void setEpisodeList(List<Episode> episodeList) {
		this.episodeList = episodeList;
	}
	
	
	
	
}
