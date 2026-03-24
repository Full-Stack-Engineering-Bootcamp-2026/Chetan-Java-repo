package com.cdac.helloworld.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
 
	 @GetMapping("/hello") 
	    public String hello() {
	        return "Hello, I am Chetan Asane!";
	    }
	 @GetMapping("/about") 
	 public ResponseEntity<String> About() {
	        return  ResponseEntity.ok(" I have completed my CDAC from IACSD Pune And my hoobies are to play cricket and play Video Games") ;
	    }
	 
	 
	 @GetMapping("/status") 
	 public String status() {
	        return "Spring Boot is running!";
	    }
	
}
