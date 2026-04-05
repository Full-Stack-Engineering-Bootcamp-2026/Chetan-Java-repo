package com.mb.spring.service;

import java.util.List;

import com.mb.spring.dto.EmployeeRequestDto;
import com.mb.spring.dto.EmployeeResponseDto;
import com.mb.spring.entity.Employee;
import com.mb.spring.exception.UserNotFoundException;

public interface EmployeeServiceInterface {

	 public EmployeeResponseDto create(EmployeeRequestDto dto) ;

	    
	    public EmployeeResponseDto getById(Long id);

	    public EmployeeResponseDto update(Long id, EmployeeRequestDto dto) ;
	    
	    public List<EmployeeResponseDto> getAllEmployees() ;

	    public void deleteById(Long id) ;
}
