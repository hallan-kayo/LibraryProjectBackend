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
	private Integer readerStatus;

=======
	public Reader() {
	}

	private Integer readerStatus;
	
>>>>>>> 2f3f385759fb03292e006324a963a9302d491b89
	@OneToMany(mappedBy = "LinkedReader")
	private Set<Reserve> reserves = new HashSet<>(); 
	
	@OneToMany(mappedBy = "LinkedReader")
	private Set<Loan> loans = new HashSet<>();
 
<<<<<<< HEAD
	public Reader() {
		
	}
=======
>>>>>>> 2f3f385759fb03292e006324a963a9302d491b89
	
	public ReaderStatus getOrderStatus() {
		return ReaderStatus.valueOf(readerStatus);
	}

}
