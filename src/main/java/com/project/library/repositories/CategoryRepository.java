package com.project.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.library.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
