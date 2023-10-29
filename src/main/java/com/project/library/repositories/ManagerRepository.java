package com.project.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.library.entities.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long>{

}
