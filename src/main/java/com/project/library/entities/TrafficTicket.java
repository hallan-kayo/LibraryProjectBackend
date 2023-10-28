package com.project.library.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class TrafficTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int daysQuantity;
	private double value;
	
	@OneToOne
	private Loan loan;

	public TrafficTicket() {
	}

	public TrafficTicket(Long id, int daysQuantity, double value) {
		this.id = id;
		this.daysQuantity = daysQuantity;
		this.value = value;
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
		return value;
	}

	public void setValue(double value) {
		this.value = value;
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
		return "TrafficTicket [id=" + id + ", daysQuantity=" + daysQuantity + ", value=" + value + "]";
	}

	
}