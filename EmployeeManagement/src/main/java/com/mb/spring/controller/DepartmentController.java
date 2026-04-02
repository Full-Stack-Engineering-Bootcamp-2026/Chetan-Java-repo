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
import com.mb.spring.service.DepartmentService;


@RestController

public class DepartmentController {
	
	@Autowired
	private DepartmentService service;

	@PostMapping("/department")
	public ResponseEntity<Department> create(@RequestBody Department department){
		return ResponseEntity.ok(service.create(department));
	}
	
	@GetMapping("/department")
	public ResponseEntity<List<Department>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	@DeleteMapping("/department/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getById(@PathVariable long id){
		
		return ResponseEntity.ok(service.getById(id));
	}
	
	
}
