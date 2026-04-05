package com.mb.rest.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}
	
	@GetMapping("/hellobean")
	public Hello_bean helloo() {
		return new Hello_bean("hello from bean");
	}
}
