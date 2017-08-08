package edu.mum.tvtube.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Episode {

	@Id @GeneratedValue
	private int id;
	private String description;
	private Date airedDate;
	private String comments;
	private double rating;
	@OneToMany
	@JoinTable(name="Episode_Cast")
	private List<Cast> castList = new ArrayList<Cast>();
	
	public Episode(){}
	
	public Episode(String description, Date airedDate, String comments, double rating) {
		super();
		this.description = description;
		this.airedDate = airedDate;
		this.comments = comments;
		this.rating = rating;
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

	public Date getAiredDate() {
		return airedDate;
	}

	public void setAiredDate(Date airedDate) {
		this.airedDate = airedDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

//	public List<Cast> getCastList() {
//		return castList;
//	}
//
//	public void setCastList(List<Cast> castList) {
//		this.castList = castList;
//	}
	
	
}
