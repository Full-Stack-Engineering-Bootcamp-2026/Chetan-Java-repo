package com.learn_data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class ConfigClass {

	@Bean
	String hello() {
		return "hello";
	}
	
	@PostConstruct
	public String welcome2() {
		return "welcome2";
	}
	
}
