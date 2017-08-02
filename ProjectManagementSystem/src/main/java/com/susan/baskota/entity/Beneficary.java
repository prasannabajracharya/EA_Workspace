package com.susan.baskota.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Beneficary {

	@Id @GeneratedValue
	private int id;
	private String name;

	public Beneficary() {}
	
	public Beneficary(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
