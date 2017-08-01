package edu.mum.hw3.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Department {
	@Id
	@GeneratedValue
	@Column(name="departmentId")
	private int id;
	private String name;
	
	@OneToMany(mappedBy="department", cascade = CascadeType.PERSIST)
	private List<Employee> employeeList = new ArrayList<Employee>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployee() {
		return employeeList;
	}
	public void setEmployee(List<Employee> employee) {
		this.employeeList = employee;
	}
	
//	public void addEmployee(Employee employee) {
//		employee.setDepartment(this);
//		employeeList.add(employee);
//	}
//
//	public void removeEmployee(Employee emp) {
//		emp.setDepartment(null);
//		employeeList.remove(emp);
//	}
		
}
