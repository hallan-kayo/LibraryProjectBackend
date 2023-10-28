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


	public Reader() {
	}

	private Integer readerStatus;
	
	@OneToMany(mappedBy = "LinkedReader")
	private Set<Reserve> reserves = new HashSet<>(); 
	
	@OneToMany(mappedBy = "LinkedReader")
	private Set<Loan> loans = new HashSet<>();
 
	
	public ReaderStatus getOrderStatus() {
		return ReaderStatus.valueOf(readerStatus);
	}

}
