package com.project.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.library.entities.Category;
import com.project.library.repositories.CategoryRepository;
import com.project.library.services.exceptions.DatabaseException;
import com.project.library.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional
	public List<Category> findAll(){
		List<Category> response = categoryRepository.findAll();
		return response;
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	public void deleteCategory(Long id) {
		try {
			categoryRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
}
