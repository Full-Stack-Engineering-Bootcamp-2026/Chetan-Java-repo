package com.example.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class WelcomeController {
	
	@Value("${app.welcome.message}")
	public String val;
	
	@GetMapping("/welcome")
	public String welcome() {
		return val;
	}
	
	
	    
	    

}
