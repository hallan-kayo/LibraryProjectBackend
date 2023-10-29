package com.project.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.library.entities.Manager;
import com.project.library.entities.Reader;
import com.project.library.services.ReaderService;

@RestController
@RequestMapping(value = "/readers")
public class ReaderController {

	@Autowired
	private ReaderService readerService;
	
	@GetMapping
	public List<Reader> findAll(){
		return readerService.findAll();
	}
	
	@GetMapping("/{id}")
	public Reader findById(@PathVariable Long id) {
		return readerService.findById(id);
	}
	
	@PostMapping
	public Reader addReader(@RequestBody Reader reader) {
		return readerService.addReader(reader);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteManager(@PathVariable Long id) {
		readerService.deleteReader(id);
	}
	
	@PutMapping(value = "/{id}")
	public Reader updateReader(@PathVariable Long id, @RequestBody Reader reader) {
		return readerService.updateReader(id, reader);
	}
}
