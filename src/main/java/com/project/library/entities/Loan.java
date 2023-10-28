package com.project.library.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant loanDate;
	private Instant returnDate;
	private Instant returnForecast;
	
	@ManyToOne
	private Book book = new Book ();
	
	@ManyToOne
	@JoinColumn(name = "Reader")
	private Reader LinkedReader = new Reader();
	
	@OneToOne(mappedBy = "loan")
	private TrafficTicket trafficTicket;

	@ManyToOne
	private Manager linkedManager = new Manager();

	public Loan() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Instant loanDate) {
		this.loanDate = loanDate;
	}

	public Instant getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Instant returnDate) {
		this.returnDate = returnDate;
	}

	public Instant getReturnForecast() {
		return returnForecast;
	}

	public void setReturnForecast(Instant returnForecast) {
		this.returnForecast = returnForecast;
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

	public Manager getLinkedManager() {
		return linkedManager;
	}

	public void setLinkedManager(Manager linkedManager) {
		this.linkedManager = linkedManager;
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
		Loan other = (Loan) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", loanDate=" + loanDate + ", returnDate=" + returnDate + ", returnForecast="
				+ returnForecast + ", book=" + book + "]";
	}
	
	
}
