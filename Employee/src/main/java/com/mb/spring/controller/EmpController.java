package com.mb.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mb.spring.service.EmpService;

import jakarta.validation.constraints.Min;

@RestController
public class EmpController {

	@Autowired
	public EmpService service;

	@GetMapping("/hello")
	public String hello() {
		return "hello chetan";
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>>  getAllEmp(){
//		return service.getallemp();
		return ResponseEntity.ok(service.getallemp());
	}
	@PostMapping("/employees")
	public ResponseEntity<Employee>  add( @RequestBody Employee emp) {
		return ResponseEntity.ok(service.empSave(emp)) ;
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>>  getById(@PathVariable @Min(value = 1,message = "entered a negative or non zero number") long id){
		
		return ResponseEntity.ok(service.getById(id));
	}
//	
	
	@PutMapping("/employees/{id}")
	public Employee update(@PathVariable long id,@RequestBody Employee emp) {
		return service.update(id,emp);
	}
//	
//	@DeleteMapping("/employees/{id}")
//	public String delete(@PathVariable int id) {
//		return service.delete(id);
//	}
//	
	@GetMapping("/employees/search")
	public List<Employee> filterd(@RequestParam String department){
		return service.filter(department);
	}
}
