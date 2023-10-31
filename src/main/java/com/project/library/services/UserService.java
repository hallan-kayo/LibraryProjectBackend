package com.project.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.library.entities.Users;
import com.project.library.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public List<Users> findAll(){
		List<Users> response = userRepository.findAll();
		return response;
	}
	
	public Users loginUser(ObjectNode body) {
		List<Users> response = this.findAll();
		for(Users user : response) {
			if(user.getEmail().equals(body.get("email").asText()) && user.getPassword().equals(body.get("password").asText())) {
				return user;
			}
		}
		return null;
	}
}
