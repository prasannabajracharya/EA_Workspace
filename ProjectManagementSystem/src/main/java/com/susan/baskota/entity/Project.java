package com.susan.baskota.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project {

	@Id @GeneratedValue
	private int id;
	private String title;
	private String location;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="project_beneficary")
	List<Beneficary> beneficaryList = new ArrayList<Beneficary>(); 
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="project_task")
	List<Task> taskList = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public List<Beneficary> getBeneficaryList() {
		return beneficaryList;
	}
	public void setBeneficaryList(List<Beneficary> beneficaryList) {
		this.beneficaryList = beneficaryList;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<Task> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
	
}
