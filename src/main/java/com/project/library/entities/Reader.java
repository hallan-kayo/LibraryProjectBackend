package com.project.library.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
<<<<<<< HEAD
=======

>>>>>>> eb9cab13b925c36268664d8d9595974d31e16076
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
	
	public Reader(Long id, String name, String username, String CPF, LocalDate dateOfBirth, String phone, String email, String password) {
		super(id, name, username, CPF,dateOfBirth,phone, email, password);
	}
	
	public Reader(Long id, String name, String username, String CPF, LocalDate dateOfBirth, String phone, String email, String password, Adress adress) {
		super(id, name, username, CPF,dateOfBirth,phone, email, password, adress);
	}

	@Override
	@JsonProperty("Type")
    public String getType() {
        return "Reader";
    }
	
	public ReaderStatus getReaderStatus() {
		return ReaderStatus.valueOf(readerStatus);
	}

}
