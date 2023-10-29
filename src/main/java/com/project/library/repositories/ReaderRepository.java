package com.project.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.library.entities.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long>{

}
