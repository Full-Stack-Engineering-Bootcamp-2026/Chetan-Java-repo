package com.learn_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class AppRunner {

	@Autowired
	public ConfigClass config;
	@Autowired
	public StudentService service;
	
	public AppRunner(ConfigClass config,StudentService service) {
		this.config=config;
		this.service=service;
	}
	
	@PostConstruct
	public String welcome() {
		return "welcome";
	}
	
}
