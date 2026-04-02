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
import com.mb.spring.entity.Skills;
import com.mb.spring.service.SkillsService;

@RestController
public class SkillsController {

	@Autowired
	private SkillsService service;
	
	@PostMapping("/skills")
	public ResponseEntity<Skills> create(@RequestBody Skills skills){
		return ResponseEntity.ok(service.create(skills));
	}
	
	@GetMapping("/skills")
	public ResponseEntity<List<Skills>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	@DeleteMapping("/skills/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/skills/{id}")
	public ResponseEntity<Skills> getById(@PathVariable long id){
		
		return ResponseEntity.ok(service.getById(id));
	}
}
