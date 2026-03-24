package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProdService;

import lombok.Getter;

@RestController
@RequestMapping("/")

public class ProdController {
	@Autowired
	public ProdService service;
	
	
	@GetMapping("/products")
	public List<Product> getAll(){
		return service.getAllProducts();
	}
	
	
	@GetMapping("/products/{id}")
	public Optional<Product>  getByid(@PathVariable int id) {
		return service.getById(id)
;	}
	    
	    

}
