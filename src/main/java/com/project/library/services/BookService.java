package com.project.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.library.entities.Book;
import com.project.library.repositories.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Transactional
	public List<Book> findAll(){
		List<Book> response = bookRepository.findAll();
		return response;
	}
}
