package com.mb.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mb.spring.controller.exception.UserNotFoundException;

@Service
public class EmpService {

	List<EmpModel> emps=new ArrayList<EmpModel>(List.of(
			new EmpModel(1l,"chetan","engg","chetan.com",100.00),
			new EmpModel(2l,"yash","it","chetan.com",100.00),

			new EmpModel(3l,"sahil","entc","chetan.com",100.00),

			new EmpModel(4l,"pravin","engg","chetan.com",100.00),

			new EmpModel(5l,"kaustii","engg","chetan.com",100.00)

			));

	public List<EmpModel> getallemp() {
		
		return emps;
	}

	public EmpModel getById(int id) throws UserNotFoundException {
		
		
		return emps.stream().filter(a->a.id==id).findFirst().orElseThrow(()->new UserNotFoundException("User not found with ID: " + id));
	}

	public EmpModel save(EmpModel emp) {
		emps.add(emp);
		return emp;
	}

	public EmpModel update(int id, EmpModel emp) {
		EmpModel oldEmp=emps.stream().filter(a->a.id==id).findFirst().orElseThrow();
		oldEmp.setName(emp.getName());
		oldEmp.setEmail(emp.getEmail());
		oldEmp.setDept(emp.getDept());
		oldEmp.setId(emp.getId());
		oldEmp.setSalary(emp.getSalary());
		
		return oldEmp;
	}

	public String delete(int id) {
//		Optional<EmpModel> removed=emps.stream().filter(a->a.id==id).findFirst();
		boolean removeIf = emps.removeIf(e ->e.getId()==id);
		return "deleted";
	}

	public List<EmpModel> filter(String dept) {
		
		return emps.stream().filter(e->e.getDept().equals(dept)).collect(Collectors.toList());
	};
	
	
	
}