package com.project.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.library.entities.Book;
import com.project.library.entities.Category;
import com.project.library.repositories.BookRepository;
import com.project.library.repositories.CategoryRepository;
import com.project.library.services.exceptions.DatabaseException;
import com.project.library.services.exceptions.DeleteException;
import com.project.library.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional
	public List<Book> findAll(){
		List<Book> response = bookRepository.findAll();
		return response;
	}
	
	@Transactional
	public Book findByid(Long id) {
		return bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Book addBook(Book book) {
		Category c = categoryRepository.findByName(book.getCategory().getName());
		if (c == null) {
			System.out.println(c);
			c = categoryRepository.save(book.getCategory());
		}
		book.setCategory(c);
		return bookRepository.save(book);
	}
	
	public void deleteBook(Long id) {
		try {
			bookRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DeleteException(e.getMessage());
		}
	}
	
	@Transactional
	public Book updateBook(Long id, Book book) {
		try {
			Book entity = bookRepository.getReferenceById(id);
			updateData(entity, book);
			return bookRepository.save(entity);
		}
		catch(EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Book entity, Book obj) {
		entity.setTitle(obj.getTitle());
	}
	
}
