package com.project.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
