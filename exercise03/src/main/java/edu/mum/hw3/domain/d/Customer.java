package edu.mum.hw3.domain.d;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id @GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="customerId")
	List<Reservation> reservationList = new ArrayList<Reservation>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
	
	
}
