package com.practice.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.Repository.ProdRepo;

@Service
public class ProdService {

	private final ProdRepo repo;
	
	public ProdService(ProdRepo repo) {
		this.repo=repo;
	}
	
	public String greet(String name) {
		return "hello"+name+" How are U?";
	}
	
	public List<String> getAllMsg(){
		return repo.getMessages();
	}
	
	
}
