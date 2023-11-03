package com.project.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.library.entities.Category;
import com.project.library.repositories.CategoryRepository;
import com.project.library.services.exceptions.DatabaseException;
import com.project.library.services.exceptions.DeleteException;
import com.project.library.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
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
	
	@Transactional
	public Category findById(Long id) {
		return categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
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
			throw new DeleteException(e.getMessage());
		}
		
	}
	
	@Transactional
	public Category updateCategory(Long id, Category category) {
		try {
			Category entity = categoryRepository.getReferenceById(id);
			updateData(entity, category);
			return categoryRepository.save(entity);
		}
		catch(EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Category entity, Category obj) {
		entity.setName(obj.getName());
	}
}
