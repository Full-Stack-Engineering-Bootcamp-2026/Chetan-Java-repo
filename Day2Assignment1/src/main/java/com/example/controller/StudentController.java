package com.example.controller;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.service.StudentService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/")


public class StudentController {
	@Autowired
	public StudentService service; 
	
	
	
	@Value("${app.batch.name}")
	public String value;
	
	@GetMapping("/batch")
	public String welcome() {
	
		return value;
	}
	@GetMapping("/students")
	public List<Student> GetStudents(){
		System.out.println(service.getAllStudents());
		return service.getAllStudents();
	}
	
	@GetMapping("/students/{id}")
	public Optional<Student>  getById(@PathVariable long id) {
		return service.getByid(id);
	}
	
	
	
	    
	    

}
