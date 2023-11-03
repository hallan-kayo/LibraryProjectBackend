package com.project.library.entities;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private LocalDate loanDate;
	private LocalDate returnDate;
	private LocalDate returnForecast;
	
	@ManyToOne
	@JsonIgnore
	private Book book = new Book ();
	
	@ManyToOne
	@JoinColumn(name = "Reader")
	private Reader LinkedReader = new Reader();

	@OneToOne(mappedBy = "loan")
	private TrafficTicket trafficTicket;


//	@ManyToOne
//	private Manager linkedManager = new Manager();

	public Loan() {
	}
	
	public Loan(LocalDate loanDate, Book book, Reader reader) {
		this.loanDate = loanDate;
		this.LinkedReader = reader;
		this.book = book;
		this.returnForecast = loanDate.plusDays(14);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanLocalDateTime(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDate getReturndate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDate getReturnForecast() {
		return returnForecast;
	}

	public void setReturnForecast(LocalDate returnForecast) {
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

//	public Manager getLinkedManager() {
//		return linkedManager;
//	}
//
//	public void setLinkedManager(Manager linkedManager) {
//		this.linkedManager = linkedManager;
//	}

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
		return "Loan [id=" + id + ", loanLocalDateTime=" + loanDate + ", returnLocalDateTime=" + returnDate+ ", returnForecast="
				+ returnForecast + ", book=" + book + "]";
	}
	
	
}
