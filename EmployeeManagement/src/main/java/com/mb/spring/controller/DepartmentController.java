package com.mb.spring.controller;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.spring.dto.ApiResponse;
import com.mb.spring.dto.DepartmentRequestDto;
import com.mb.spring.dto.DepartmentResponseDto;
import com.mb.spring.entity.Department;
import com.mb.spring.service.DepartmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/departments")
    public ResponseEntity<ApiResponse<DepartmentResponseDto>> create(@Valid @RequestBody DepartmentRequestDto dto) {

        DepartmentResponseDto department = departmentService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(201, "Department created successfully", department, LocalDateTime.now()));
    }

    @GetMapping("/departments")
    public ResponseEntity<ApiResponse<List<DepartmentResponseDto>>> getAll() {

        List<DepartmentResponseDto> departments = departmentService.getAll();
               
        return ResponseEntity.ok( new ApiResponse<>(200, "Departments fetched successfully", departments, LocalDateTime.now()));
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<ApiResponse<DepartmentResponseDto>> getById(@PathVariable Long id) {

        DepartmentResponseDto department = departmentService.getById(id);
                
        return ResponseEntity.ok(new ApiResponse<>(200, "Department fetched by id ", department, LocalDateTime.now()));
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {

        departmentService.deleteById(id);

        return ResponseEntity.ok(new ApiResponse<>(200, "Department deleted successfully", null, LocalDateTime.now()));
    }
}