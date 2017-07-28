package edu.mum.hw3.domain.d;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.mum.hw3.domain.b.Book;

@Entity
public class Reservation {
	@Id @GeneratedValue
	private int id;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="bookId")
	private Book book;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
