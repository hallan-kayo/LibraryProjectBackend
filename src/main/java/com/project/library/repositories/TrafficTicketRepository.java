package com.project.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.library.entities.TrafficTicket;

public interface TrafficTicketRepository extends JpaRepository<TrafficTicket, Long> {

}
