package com.mb.spring.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmpModel {
	
	//id, name, department, email, salary
	@NotNull
	public long id;
	@NotBlank(message = "should not be blank")
	public String name;
	@NotBlank(message = "should not be blank")
	public String dept;
	@Email
	public String email;
	@NotNull
	public double salary;

}
