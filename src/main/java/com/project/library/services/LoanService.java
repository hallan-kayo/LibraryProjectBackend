package com.project.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.library.entities.Loan;
import com.project.library.repositories.LoanRepository;
import com.project.library.services.exceptions.DatabaseException;
import com.project.library.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;
	
	@Transactional
	public List<Loan> findAll(){
		List<Loan> response = loanRepository.findAll();
		return response;
	}
	
	@Transactional
	public Loan findById(Long id) {
		return loanRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Loan addLoan(Loan loan) {
		return loanRepository.save(loan);
	}
	
	public void deleteLoan(Long id) {
		try {
			loanRepository.findById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Loan updateLoan (Long id, Loan loan) {
		try {
			Loan entity = loanRepository.getReferenceById(id);
			updateData(entity, loan);
			return loanRepository.save(entity);
		}
		catch(EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Loan entity, Loan obj) {
//		entity.
		
	}
}
