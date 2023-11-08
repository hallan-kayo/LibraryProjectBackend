package com.project.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.library.entities.Reserve;
import com.project.library.repositories.ReserveRepository;
import com.project.library.services.exceptions.DeleteException;
import com.project.library.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ReserveService {

	@Autowired
	private ReserveRepository reserveRepository;
	
	@Transactional
	public List<Reserve> findAll(){
		List<Reserve> response = reserveRepository.findAll();
		return response;
	}
	
	@Transactional
	public Reserve findById(Long id) {
		return reserveRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Reserve addReserve(Reserve reserve) {
		return reserveRepository.save(reserve);
	}
	
	public void deleteReserve(Long id) {
		try {
			reserveRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DeleteException(e.getMessage());
		}
	}
	
	@Transactional
	public Reserve updateReserve(Long id, Reserve reserve) {
		try {
			Reserve entity = reserveRepository.getReferenceById(id);
			updateData(entity, reserve);
			return reserveRepository.save(entity);
		}
		catch(EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Reserve entity, Reserve obj) {
		entity.setReserveDate(obj.getReserveDate());
		
	}
}
