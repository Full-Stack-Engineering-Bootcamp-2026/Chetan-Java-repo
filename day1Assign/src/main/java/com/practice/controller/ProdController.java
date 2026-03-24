package com.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Service.ProdService;

import java.util.List;


@RestController
@RequestMapping("/")
public class ProdController {
	
	private final ProdService service;
	
	public ProdController(ProdService service) {
		this.service=service;
	}
	
	
	    
	    @GetMapping("/messages")
	    	public List<String> getAll(){
	    		return service.getAllMsg();
	    	}
	    
	    @GetMapping("/greet/{name}")
	    	public String greet(@PathVariable String name) {
	    		return service.greet(name);
	    	}
	    
	    

}
