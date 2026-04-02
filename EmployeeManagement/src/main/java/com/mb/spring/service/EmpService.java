package com.mb.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mb.spring.dto.EmpResDto;
import com.mb.spring.dto.EmpWithSkills;
import com.mb.spring.entity.Department;
import com.mb.spring.entity.Emp;
import com.mb.spring.entity.EmpProfile;
import com.mb.spring.entity.Skills;
import com.mb.spring.exception.UserNotFoundException;
import com.mb.spring.repo.DepartmentRepo;
import com.mb.spring.repo.EmployeeRepo;
import com.mb.spring.repo.ProfileRepo;
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
	@Autowired
	private ProfileRepo profileRepo;


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
	

	public Emp update(long id, EmpResDto emp) {

		Emp e = repo.findById(id).orElseThrow(() -> new UserNotFoundException("Emp not found with id "+id));
		
		Department d=deptRepo.findById(e.getDepartment().getDeptId()).orElseThrow(()->new UserNotFoundException("dept not found with id "+id));
		
		EmpProfile p=profileRepo.findById(e.getProfile().getProfile_id()).orElseThrow(()->new UserNotFoundException("profile not found with id "+id));
		
		//skillrepo.findAllById(emp.getSkills().stream().map(skill->skill.getId()))
		//skillrepo.findById(emp.getSkills().stream().map(skill->skill.getId()).toList());
		List<Skills> s=skillrepo.findAll();
		
		e.setEmail(emp.getEmail());
		e.setName(emp.getName());
	
		e.setDepartment(d);
		e.setProfile(p);
		
		return e;
	}
	

	public void delete(long id) {

		repo.findById(id).orElseThrow(() -> new UserNotFoundException("emp id invalid"));
		
		repo.deleteById(id);

	}

//	public List<Emp> getBySkills(String skill) {
//		// TODO Auto-generated method stub
//		return repo.findEmployeesBySkill(skill);
//	}


}
