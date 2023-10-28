package com.project.library.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "Manager")
public class Manager extends Users{
	
	@OneToMany(mappedBy = "linkedManager")
	private List<Loan> linkedLoans = new ArrayList<>();

	public Manager() {
	}

	public List<Loan> getLinkedLoans() {
		return linkedLoans;
	}

}
