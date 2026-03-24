package com.example.controller;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.GreetingRepo;
import com.example.service.GreetingService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/")


public class GreetingController {
	
	@Autowired
	public GreetingService service; 
	
	
	@GetMapping("/msgs")
	public List<String> msgs(){
		return service.getAllMsg();
	}
	
	@GetMapping("/greet/{name}")
	public String greet(@PathVariable String name) {
		return service.greet(name);
	}
	
	
	    
	    

}
