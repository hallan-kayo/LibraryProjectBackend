package com.project.library.entities;

import java.util.ArrayList;
import java.util.Date;
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

	public Manager(Long id, String name, String username, String CPF, Date dateOfBirth, String phone, String email, String password) {
		super(id, name, username, CPF,dateOfBirth,phone, email, password);
	}
	
	public List<Loan> getLinkedLoans() {
		return linkedLoans;
	}

}
