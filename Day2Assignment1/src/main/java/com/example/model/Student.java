package com.example.model;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor

@Getter
@Setter

public class Student {

	
	public long id;
	public String name;
	public String batch;
	public String email;
	
}
