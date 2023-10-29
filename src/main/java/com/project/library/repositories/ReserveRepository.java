package com.project.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.library.entities.Reserve;

public interface ReserveRepository extends JpaRepository<Reserve, Long>{

}
