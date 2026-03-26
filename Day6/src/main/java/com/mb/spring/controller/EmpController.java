package com.mb.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.constraints.Min;
@RestController
@Validated
public class EmpController {
	@Autowired
	public EmpService service;

	@GetMapping("/hello")
	public String hello() {
		return "hello chetan";
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmpModel>>  getAllEmp(){
//		return service.getallemp();
		return ResponseEntity.ok(service.getallemp());
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmpModel>  getById(@PathVariable @Min(value = 1,message = "entered a negative or non zero number") int id){
		EmpModel emp=service.getById(id);
		return ResponseEntity.ok(emp);
	}
	
	@PostMapping("/employees")
	public EmpModel add( @RequestBody EmpModel emp) {
		return service.save(emp);
	}
	@PutMapping("/employees/{id}")
	public EmpModel update(@PathVariable int id,@RequestBody EmpModel emp) {
		return service.update(id,emp);
	}
	
	@DeleteMapping("/employees/{id}")
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}
	
	@GetMapping("/employees/search")
	public List<EmpModel> filterd(@RequestParam String department){
		return service.filter(department);
	}

}