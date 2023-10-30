package com.project.library.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.library.entities.Manager;
import com.project.library.services.ManagerService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/managers")
public class ManagerController {

	@Autowired
	private ManagerService managerServices;
	
	@GetMapping
	public List<Manager> findAll(){
		return managerServices.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Manager findById(@PathVariable Long id) {
		return managerServices.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Manager> addManager(@RequestBody Manager manager) {
		manager = managerServices.addManager(manager);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(manager.getId()).toUri();
		return ResponseEntity.created(uri).body(manager);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteManager(@PathVariable Long id) {
		managerServices.deleteManager(id);
	}
	
	@PutMapping(value = "/{id}")
	public Manager updateManager(@PathVariable Long id, @RequestBody Manager manager) {
		return managerServices.updateManager(id, manager);
	}
	
}
