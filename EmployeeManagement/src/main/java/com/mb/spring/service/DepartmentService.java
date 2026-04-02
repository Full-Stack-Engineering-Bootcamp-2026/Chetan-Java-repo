package com.mb.spring.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.spring.entity.Department;
import com.mb.spring.exception.UserNotFoundException;
import com.mb.spring.repo.DepartmentRepo;

import jakarta.transaction.Transactional;


@Service
@Transactional

public class DepartmentService {
	
	@Autowired
	private DepartmentRepo repo;

	public  Department create(Department department) {
		// TODO Auto-generated method stub
		return repo.save(department);
	}

	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		repo.findById(id).orElseThrow(()->new UserNotFoundException("id does not exist"));
		repo.deleteById(id);
	}

	public Department getById(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()-> new UserNotFoundException("cannot get Id for department getbyid"));
	}
	
	
	
}
