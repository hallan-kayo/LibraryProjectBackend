package com.project.library.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.library.entities.enums.ReaderStatus;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "Reader")
public class Reader extends Users {

	private Integer readerStatus = 1;
	
	@OneToMany(mappedBy = "LinkedReader")
	@JsonIgnore
	private Set<Reserve> reserves = new HashSet<>(); 
	
	@OneToMany(mappedBy = "LinkedReader")
	private Set<Loan> loans = new HashSet<>();
 
	
	public Reader() {
	}
	
	public Reader(Long id, String name, String username, String CPF, Date dateOfBirth, String phone, String email, String password) {
		super(id, name, username, CPF,dateOfBirth,phone, email, password);
	}

	@Override
	@JsonProperty("Type")
    public String getType() {
        return "Reader";
    }
	
	public ReaderStatus getOrderStatus() {
		return ReaderStatus.valueOf(readerStatus);
	}

}
