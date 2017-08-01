package edu.mum.hw3.domain.b;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Publisher {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
