package com.mb.spring.service;

import java.util.List;

import com.mb.spring.dto.DepartmentRequestDto;
import com.mb.spring.dto.DepartmentResponseDto;
import com.mb.spring.entity.Department;
import com.mb.spring.exception.UserNotFoundException;

public interface DepartmentServiceInterfece {

		public DepartmentResponseDto create(DepartmentRequestDto dto) ;

	    public List<DepartmentResponseDto> getAll() ;

	    public DepartmentResponseDto getById(Long id);
	    
	    public void deleteById(Long id) ;
}
