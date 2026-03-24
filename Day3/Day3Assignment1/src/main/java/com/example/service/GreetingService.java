package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.GreetingRepo;

import lombok.AllArgsConstructor;



@Service

public class GreetingService {
	
	
	public GreetingRepo repo;
	
	@Autowired
	public GreetingService(GreetingRepo repo) {
		super();
		this.repo = repo;
	}
	
	

	public List<String> getAllMsg() {
		
		return repo.msg();
	}



	public String greet(String abc) {
		
		return "hello " +abc+" !!";
	}



	
	
	
		
		
				
}
