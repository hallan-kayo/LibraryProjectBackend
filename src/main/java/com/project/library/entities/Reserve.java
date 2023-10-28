package com.project.library.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Reserve {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant reserveDate;
	
	@ManyToOne
	private Book book = new Book();
 	
	@ManyToOne
	private Reader LinkedReader = new Reader();
	
	public Reserve () {
		
	}
	

	public Reserve(Long id, Instant reserveDate, Book book) {
		this.id = id;
		this.reserveDate = reserveDate;
		this.book = book;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Instant reserveDate) {
		this.reserveDate = reserveDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	

	public Reader getLinkedReader() {
		return LinkedReader;
	}


	public void setLinkedReader(Reader linkedReader) {
		LinkedReader = linkedReader;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserve other = (Reserve) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Reserve [id=" + id + ", reserveDate=" + reserveDate + ", book=" + book + "]";
	}
    
	
	
}
