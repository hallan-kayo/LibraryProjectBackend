package com.project.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.library.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{

}
