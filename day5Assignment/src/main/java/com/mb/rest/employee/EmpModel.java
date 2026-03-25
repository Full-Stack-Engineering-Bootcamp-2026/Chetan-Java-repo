package com.mb.rest.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmpModel {
	
	//id, name, department, email, salary
	public long id;
	public String name;
	public String dept;
	public String email;
	public double salary;

}
