package com.learn_data;

import org.springframework.stereotype.Component;

@Component
public class StudComponent {

	public StudentService service;
	
	public StudComponent(StudentService service) {
		this.service=service;
		System.out.println("from stude comtroller");
	}
}
