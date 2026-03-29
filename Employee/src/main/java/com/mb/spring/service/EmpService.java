package com.mb.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.spring.controller.Employee;
import com.mb.spring.controller.exception.UserNotFoundException;
import com.mb.spring.repo.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpService {
	@Autowired
	public EmployeeRepo repo;
	
	

public List<Employee> getallemp() {
		
		return repo.findAll();
	}

public Employee empSave(Employee emp) {
	
	return repo.save(emp);
}


	public Optional<Employee> getById(long id) throws UserNotFoundException {
		
		
		return repo.findById(id);
		}


	public Employee update(long id, Employee emp) {
		

	    Employee existing = repo.findById(id)
	            .orElseThrow(() -> new UserNotFoundException("Employee not found"));

	    existing.setName(emp.getName());
	    existing.setDept(emp.getDept());
	    existing.setEmail(emp.getEmail());
	    existing.setSalary(emp.getSalary());

	    return repo.save(existing);
	}
//
//	public String delete(int id) {
//	Optional<EmpModel> removed=emps.stream().filter(a->a.id==id).findFirst();
//		boolean removeIf = emps.removeIf(e ->e.getId()==id);
//		return "deleted";
//	}
//
	public List<Employee> filter(String dept) {
		return repo.findByDept(dept);
		
	};
}
