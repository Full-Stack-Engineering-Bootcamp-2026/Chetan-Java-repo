package com.mb.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.spring.dto.EmpResDto;
import com.mb.spring.entity.Department;
import com.mb.spring.entity.Emp;
import com.mb.spring.entity.Skills;
import com.mb.spring.exception.UserNotFoundException;
import com.mb.spring.repo.DepartmentRepo;
import com.mb.spring.repo.EmployeeRepo;
import com.mb.spring.repo.SkillsRepo;



@Service
@org.springframework.transaction.annotation.Transactional
public class EmpService {
	@Autowired
	public EmployeeRepo repo;
	@Autowired
	private DepartmentRepo deptRepo;
	@Autowired
	private SkillsRepo skillrepo;
	@Autowired
	private  ModelMapper modelMapper;


	public List<EmpResDto> getallemp() {

	    return repo.findAll().stream().map(emp -> {

	        EmpResDto dto = modelMapper.map(emp, EmpResDto.class);
	        
	        dto.setDeptId(emp.getDepartment().getDeptId());
  
	        return dto;

	    }).toList();
	    
	}

	public Emp empSave(Emp emp) {

	    if (emp.getDepartment() != null) {
	        Department savedDept = deptRepo.findByDeptName(emp.getDepartment().getDeptName());

	        emp.setDepartment(savedDept);
	    }
	   
	    return repo.save(emp);
	}
	

	public Emp getById(long id)  {

		return repo.findById(id).orElseThrow(()->new UserNotFoundException("id does not exist"));
	}
	

	public Emp update(long id, Emp emp) {

		Emp e = repo.findById(id).orElseThrow(() -> new UserNotFoundException("Emp not found with id "+id));
	
		
		e.setEmail(emp.getEmail());
		e.setName(emp.getName());
		System.out.println(emp.getDepartment());
		System.out.println(emp.getDepartment().getDeptName());
		e.setDepartment(emp.getDepartment());
		e.setProfile(emp.getProfile());
		e.setSkills(emp.getSkills());
		
		return e;
	}
	

	public void delete(long id) {

		repo.findById(id).orElseThrow(() -> new UserNotFoundException("emp id invalid"));
		
		repo.deleteById(id);

	}


}
