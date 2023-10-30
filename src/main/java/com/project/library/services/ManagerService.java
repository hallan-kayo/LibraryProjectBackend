package com.project.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.library.entities.Manager;
import com.project.library.entities.Manager;
import com.project.library.repositories.ManagerRepository;
import com.project.library.services.exceptions.DatabaseException;
import com.project.library.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository managerRepository;
	
	@Transactional
	public List<Manager> findAll(){
		List<Manager> response = managerRepository.findAll();
		return response;
	}
	
	@Transactional
	public Manager findById(Long id) {
		return managerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Manager addManager(Manager manager) {
		return managerRepository.save(manager);
	}
	
	public void deleteManager(Long id) {
		try {
			managerRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	@Transactional
	public Manager updateManager(Long id, Manager manager) {
		try {
			Manager entity = managerRepository.getReferenceById(id);
			updateData(entity, manager);
			return managerRepository.save(entity);
		}
		catch(EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Manager entity, Manager obj) {
		entity.setName(obj.getName());
		entity.setCPF(obj.getCPF());
		entity.setDateOfBirth(obj.getDateOfBirth());
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());
		entity.setUsername(obj.getUsername());
		entity.setPhone(obj.getPhone());
	}
}
