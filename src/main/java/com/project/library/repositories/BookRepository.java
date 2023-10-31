package com.project.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.library.entities.Book;
import com.project.library.entities.Category;

public interface BookRepository extends JpaRepository<Book, Long>{

}
