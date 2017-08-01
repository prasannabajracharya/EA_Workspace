package edu.mum.hw3.domain.f;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import edu.mum.hw3.domain.Employee;

@Entity
public class Office {

	@Id @GeneratedValue
	@Column(name="officeId")
	private int id;
	private String roomNumber;
	private String building;
	
	@OneToMany(mappedBy="office")
	private List<Employee> empList = new ArrayList<Employee>();

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	} 
	
	
}
