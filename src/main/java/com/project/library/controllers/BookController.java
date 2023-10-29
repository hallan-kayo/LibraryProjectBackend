package com.project.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.library.entities.Book;
import com.project.library.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> findAll(){
		return bookService.findAll();
	}
}
