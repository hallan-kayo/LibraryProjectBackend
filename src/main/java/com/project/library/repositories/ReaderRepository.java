package com.project.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.library.entities.Users;

public interface ReaderRepository extends JpaRepository<Users, Long>{

}
