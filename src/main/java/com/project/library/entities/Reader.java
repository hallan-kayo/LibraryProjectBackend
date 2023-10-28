package com.project.library.entities;

import java.util.HashSet;
import java.util.Set;

import com.project.library.entities.enums.ReaderStatus;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "Reader")
public class Reader extends Users {

<<<<<<< HEAD
	public Reader() {
	}
=======
	private Integer readerStatus;
>>>>>>> ef37c4c6aff15956c3780bd40dc77771ac1b17f5
	
	@OneToMany(mappedBy = "LinkedReader")
	private Set<Reserve> reserves = new HashSet<>(); 
	
	@OneToMany(mappedBy = "LinkedReader")
	private Set<Loan> loans = new HashSet<>();
 
	public Reader() {
		super();
	}
	
	public ReaderStatus getOrderStatus() {
		return ReaderStatus.valueOf(readerStatus);
	}

}
