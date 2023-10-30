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

import com.project.library.entities.Reserve;
import com.project.library.services.ReserveService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/reserves")
public class ReserveController {

	@Autowired
	private ReserveService reserveService;
	
	@GetMapping
	public List<Reserve> findAll(){
		return reserveService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Reserve findById(@PathVariable Long id) {
		return reserveService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Reserve> addReserve(@RequestBody Reserve reserve){
		reserve = reserveService.addReserve(reserve);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(reserve.getId()).toUri();
		return ResponseEntity.created(uri).body(reserve);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteReserve(@PathVariable Long id) {
		reserveService.deleteReserve(id);
	}
	
	@PutMapping(value = "/{id}")
	public Reserve updateReserve(@PathVariable Long id,@RequestBody Reserve reserve) {
		return reserveService.updateReserve(id, reserve);
	}
}
