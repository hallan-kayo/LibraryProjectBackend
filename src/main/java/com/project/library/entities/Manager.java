package com.project.library.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Manager")
public class Manager extends Users{
	
	
//	@OneToMany(mappedBy = "linkedManager")
//	private List<Loan> linkedLoans = new ArrayList<>();
	

	public Manager() {
	}

	public Manager(Long id, String name, String username, String CPF, LocalDate dateOfBirth, String phone, String email, String password) {
		super(id, name, username, CPF,dateOfBirth,phone, email, password);
	}
	

//	@JsonIgnore
//	public List<Loan> getLinkedLoans() {
//		return linkedLoans;
//	}
	
	@Override
	@JsonProperty("Type")
    public String getType() {
        return "Manager";
    }

}
