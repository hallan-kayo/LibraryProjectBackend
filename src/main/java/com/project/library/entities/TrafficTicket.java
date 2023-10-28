package com.project.library.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class TrafficTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int daysQuantity;
	private double fineValue;
	
	@OneToOne
	private Loan loan;

	public TrafficTicket() {
		
	}

<<<<<<< HEAD
	public TrafficTicket(Long id, int daysQuantity, double value, Loan loan) {
		this.id = id;
		this.daysQuantity = daysQuantity;
		this.value = value;
		this.loan = loan;
=======
	public TrafficTicket(Long id, int daysQuantity, double fineValue) {
		this.id = id;
		this.daysQuantity = daysQuantity;
		this.fineValue = fineValue;
>>>>>>> 2f3f385759fb03292e006324a963a9302d491b89
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDaysQuantity() {
		return daysQuantity;
	}

	public void setDaysQuantity(int daysQuantity) {
		this.daysQuantity = daysQuantity;
	}

	public double getValue() {
		return fineValue;
	}

	public void setValue(double fineValue) {
		this.fineValue = fineValue;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
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
		TrafficTicket other = (TrafficTicket) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "TrafficTicket [id=" + id + ", daysQuantity=" + daysQuantity + ", value=" + value + ", loan=" + loan
				+ "]";
=======
		return "TrafficTicket [id=" + id + ", daysQuantity=" + daysQuantity + ", fineValue=" + fineValue + "]";
>>>>>>> 2f3f385759fb03292e006324a963a9302d491b89
	}
	
	
	
	
	
}
