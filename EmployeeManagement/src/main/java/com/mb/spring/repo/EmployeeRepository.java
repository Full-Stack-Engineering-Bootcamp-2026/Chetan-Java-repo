package com.mb.spring.repo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mb.spring.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	@Override
//	@EntityGraph(value = "emp.detail")
    Optional<Employee> findById(Long id);
	
	

	//@EntityGraph(value = "emp.detail")
	 List<Employee> findAll();


}
