package com.project.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.library.entities.TrafficTicket;
import com.project.library.repositories.TrafficTicketRepository;
import com.project.library.services.exceptions.DatabaseException;
import com.project.library.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TrafficTicketService {

	@Autowired
	private TrafficTicketRepository trafficTicketRepository;
	
	@Transactional
	public List<TrafficTicket> findAll(){
		List<TrafficTicket> response = trafficTicketRepository.findAll();
		return response;
	}
	
	@Transactional
	public TrafficTicket findById(Long id) {
		return trafficTicketRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public TrafficTicket addTrafficTicket(TrafficTicket trafficTicket) {
		return trafficTicketRepository.save(trafficTicket);
	}
	
	public void deleteTrafficTicket(Long id) {
		try {
			trafficTicketRepository.findById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public TrafficTicket updateTrafficTicket(Long id, TrafficTicket trafficTicket) {
		try {
			TrafficTicket entity = trafficTicketRepository.getReferenceById(id);
			updateData(entity, trafficTicket);
			return trafficTicketRepository.save(entity);
		}
		catch(EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(TrafficTicket entity, TrafficTicket obj) {
		entity.setfineValue(obj.getDaysQuantity());
	}
		
	
}
