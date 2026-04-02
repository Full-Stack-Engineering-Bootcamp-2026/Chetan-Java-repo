package com.mb.spring.controller;

import java.util.List;

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

import com.mb.spring.dto.EmpResDto;
import com.mb.spring.dto.EmpWithSkills;
import com.mb.spring.entity.Emp;
import com.mb.spring.service.EmpService;



@RestController
public class EmpController {

	@Autowired
	public EmpService service;

	
	@GetMapping(path="/employees")
	public ResponseEntity<List<EmpResDto>>  getAllEmp(){
//		return service.getallemp();
		return ResponseEntity.ok(service.getallemp());
	}
	
	@PostMapping(path="/employees")
	public ResponseEntity<Emp>  add( @RequestBody Emp emp) {
		return ResponseEntity.ok(service.empSave(emp)) ;
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Emp>  getById(@PathVariable  long id){
		
		return ResponseEntity.ok(service.getById(id));
	}

	
	@PutMapping("/employees/{id}")
	public Emp update(@PathVariable long id,@RequestBody EmpResDto emp) {
		return service.update(id,emp);
	}
	
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
//	@GetMapping("/employee")
//	public ResponseEntity<List<Emp>> EmpBySkills(@PathVariable String skill){
//		return ResponseEntity.ok(service.getBySkills(skill));
//	}
//	
	
	

}
