package com.mb.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mb.spring.entity.Department;
import com.mb.spring.entity.EmpProfile;
import com.mb.spring.service.ProfileService;

@RestController
public class ProfileController {

	@Autowired
	private ProfileService service;
	
	@PostMapping("/profile")
	public ResponseEntity<EmpProfile> create(@RequestBody EmpProfile profile){
		return ResponseEntity.ok(service.create(profile));
	}
	
	@GetMapping("/profile")
	public ResponseEntity<List<EmpProfile>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@DeleteMapping("/profile/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/profile/{id}")
	public ResponseEntity<EmpProfile> getById(@PathVariable long id){
		
		return ResponseEntity.ok(service.getById(id));
	}
	
//	@GetMapping("/profile/get")
	
}
