package com.project.library.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.library.entities.Loan;
import com.project.library.services.LoanService;



@RestController
@CrossOrigin("*")
@RequestMapping(value = "/loans")
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@GetMapping
	public List<Loan> findAll(){
		return loanService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Loan findById(@PathVariable Long id) {
		return loanService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Loan> addLoan(@RequestBody Loan loan){
		loan = loanService.addLoan(loan);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(loan.getId()).toUri();
		return ResponseEntity.created(uri).body(loan);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteLoan(Long id) {
		loanService.deleteLoan(id);
	}
	
	@PutMapping(value = "/{id}")
	public Loan updateLoan(@PathVariable Long id,@RequestBody Loan loan) {
		return loanService.updateLoan(id, loan);
	}
}
