package edu.mum.hw2.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Actor {
	
	@Column(name="actorRating")
	private double rating;
	
	@Column(name="role")
	private String character;
	
	@Column(name="actorName")
	private String name;
	
	public Actor(){
		
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
