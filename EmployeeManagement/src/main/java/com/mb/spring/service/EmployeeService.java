package com.mb.spring.service;

import java.util.ArrayList;
import  com.mb.spring.entity.Profile;
import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mb.spring.dto.DepartmentRequestDto;

import com.mb.spring.dto.EmployeeRequestDto;
import com.mb.spring.dto.EmployeeResponseDto;
import com.mb.spring.entity.Department;
import com.mb.spring.entity.Employee;
import com.mb.spring.entity.Skill;
import com.mb.spring.exception.UserNotFoundException;
import com.mb.spring.repo.DepartmentRepository;
import com.mb.spring.repo.EmployeeRepository;
import com.mb.spring.repo.ProfileRepository;
import com.mb.spring.repo.SkillRepository;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService implements EmployeeServiceInterface{

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final SkillRepository skillRepository;
    private final ProfileRepository profileRepository;
    private final ModelMapper modelMapper;

 
    
    public EmployeeResponseDto create(EmployeeRequestDto dto) {

        Employee employee = modelMapper.map(dto, Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);

        return modelMapper.map(savedEmployee, EmployeeResponseDto.class);
    }

    
    public EmployeeResponseDto getById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee not found"));

        return modelMapper.map(employee, EmployeeResponseDto.class);
    }

    public EmployeeResponseDto update(Long id, EmployeeRequestDto dto) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee not found"));

        modelMapper.map(dto, employee);

        Employee updated = employeeRepository.save(employee);

        return modelMapper.map(updated, EmployeeResponseDto.class);
    }
    
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(emp -> modelMapper.map(emp, EmployeeResponseDto.class))
                .toList();
    }


    public void deleteById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee not found"));

        employeeRepository.delete(employee);
    }
}