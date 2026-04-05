package com.mb.spring.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.spring.dto.DepartmentRequestDto;
import com.mb.spring.dto.DepartmentResponseDto;
import com.mb.spring.entity.Department;
import com.mb.spring.exception.UserNotFoundException;
import com.mb.spring.repo.DepartmentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentResponseDto create(DepartmentRequestDto dto) {

        Department department = modelMapper.map(dto, Department.class);
        Department dept = departmentRepository.save(department);

        return modelMapper.map(dept, DepartmentResponseDto.class);
    }


    public List<DepartmentResponseDto> getAll() {
        return departmentRepository.findAll()
                .stream()
                .map(dept -> modelMapper.map(dept, DepartmentResponseDto.class))
                .toList();
    }


    public DepartmentResponseDto getById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Department not found"));

        return modelMapper.map(department, DepartmentResponseDto.class);
    }

    public void deleteById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Department not found"));

        departmentRepository.delete(department);
    }
}