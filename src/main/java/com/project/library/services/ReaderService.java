package com.project.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.library.entities.Adress;
import com.project.library.entities.Reader;
import com.project.library.repositories.AdressRepository;
import com.project.library.repositories.ReaderRepository;
import com.project.library.services.exceptions.DatabaseException;
import com.project.library.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ReaderService {

	@Autowired
	private ReaderRepository readerRepository;
	
	@Autowired
	private AdressRepository adressRepository;
	
	@Transactional
	public List<Reader> findAll(){
		List<Reader> response = readerRepository.findAll();
		return response;
	}
	
	@Transactional
	public Reader findById(Long id){
		return readerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Reader addReader(Reader reader) {
		Adress userAdress = adressRepository.save(reader.getAdress());
		reader.setAdress(userAdress);
		return readerRepository.save(reader);
	}
	
	public void deleteReader(Long id) {
		try {
			readerRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	@Transactional
	public Reader updateReader(Long id, Reader reader) {
		try {
			Reader entity = readerRepository.getReferenceById(id);
			updateData(entity, reader);
			return readerRepository.save(entity);
		}
		catch(EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Reader entity, Reader obj) {
		entity.setName(obj.getName());
		entity.setCPF(obj.getCPF());
		entity.setLocalDateOfBirth(obj.getLocalDateOfBirth());
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());
		entity.setUsername(obj.getUsername());
		entity.setPhone(obj.getPhone());
	}
}
