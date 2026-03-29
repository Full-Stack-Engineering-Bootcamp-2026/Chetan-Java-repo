package com.mb.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.spring.controller.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	List<Employee> findByDept(String dept);

	
	

}
