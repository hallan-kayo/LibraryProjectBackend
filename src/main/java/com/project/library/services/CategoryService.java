package com.project.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.library.entities.Category;
import com.project.library.repositories.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository category;
	
	@Transactional
	public List<Category> findAll(){
		List<Category> response = category.findAll();
		return response;
	}
}
