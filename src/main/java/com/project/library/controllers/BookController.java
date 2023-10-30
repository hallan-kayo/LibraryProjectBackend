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

import com.project.library.entities.Book;
import com.project.library.services.BookService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> findAll(){
		return bookService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Book findById(@PathVariable Long id) {
		return bookService.findByid(id);
	}
	
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		book = bookService.addBook(book);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(book.getId()).toUri();
		return ResponseEntity.created(uri).body(book);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
	}
	
	@PutMapping(value = "/{id}")
	public Book updateBook(@PathVariable Long id,@RequestBody Book book) {
		return bookService.updateBook(id, book);
	}
}
