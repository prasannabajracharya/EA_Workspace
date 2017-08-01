package edu.mum.hw3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import edu.mum.hw3.domain.f.Office;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private int employeeNumber;
	
	@Column(name="emp_Name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="officeId")
	private Office office;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	
	
}
