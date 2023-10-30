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

import com.project.library.entities.TrafficTicket;
import com.project.library.services.TrafficTicketService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/fines")
public class TrafficTicketController {

	@Autowired
	private TrafficTicketService trafficTicketService;
	
	@GetMapping
	public List<TrafficTicket> findAll(){
		return trafficTicketService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public TrafficTicket findById(@PathVariable Long id) {
		return trafficTicketService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<TrafficTicket> addTrafficTicket(@RequestBody TrafficTicket trafficTicket){
		trafficTicket = trafficTicketService.addTrafficTicket(trafficTicket);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(trafficTicket.getId()).toUri();
		return ResponseEntity.created(uri).body(trafficTicket);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteTrafficTicket(@RequestBody Long id) {
		trafficTicketService.deleteTrafficTicket(id);
	}
	
	@PutMapping(value = "/{id}")
	public TrafficTicket updateTrafficTicket(@PathVariable Long id, @RequestBody TrafficTicket trafficTicket ) {
		return trafficTicketService.updateTrafficTicket(id, trafficTicket);
	}
	
}
