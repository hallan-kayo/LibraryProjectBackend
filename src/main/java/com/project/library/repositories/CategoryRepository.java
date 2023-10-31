package com.project.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.library.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	 @Query(value = "SELECT * FROM category c WHERE c.name = :name", nativeQuery = true)
	    Category findByName(String name);
}
