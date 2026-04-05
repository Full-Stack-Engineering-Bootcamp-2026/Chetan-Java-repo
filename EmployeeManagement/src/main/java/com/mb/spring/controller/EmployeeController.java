package com.mb.spring.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.mb.spring.dto.ApiResponse;
import com.mb.spring.dto.EmployeeRequestDto;
import com.mb.spring.dto.EmployeeResponseDto;
import com.mb.spring.entity.Employee;
import com.mb.spring.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<ApiResponse<List<EmployeeResponseDto>>> getAllEmployees() {

        List<EmployeeResponseDto> employees = employeeService.getAllEmployees();

        ApiResponse<List<EmployeeResponseDto>> response =
                new ApiResponse<>(200, "Employees fetched successfully", employees, LocalDateTime.now());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/employees")
    public ResponseEntity<ApiResponse<EmployeeResponseDto>> create(
            @Valid @RequestBody EmployeeRequestDto dto) {

        EmployeeResponseDto employee = employeeService.create(dto);

        ApiResponse<EmployeeResponseDto> response =
                new ApiResponse<>(201, "Employee created successfully", employee, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponseDto>> getById(@PathVariable Long id) {

        EmployeeResponseDto employee = employeeService.getById(id);

        ApiResponse<EmployeeResponseDto> response =
                new ApiResponse<>(200, "Employee fetched by id "+id, employee, LocalDateTime.now());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponseDto>> update(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDto dto) {

        EmployeeResponseDto employee = employeeService.update(id, dto);

        ApiResponse<EmployeeResponseDto> response =
                new ApiResponse<>(200, "Employee updated successfully", employee, LocalDateTime.now());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {

        employeeService.deleteById(id);

        ApiResponse<Void> response =
                new ApiResponse<>(200, "Employee deleted successfully by id"+id, null, LocalDateTime.now());

        return ResponseEntity.ok(response);
    }
}