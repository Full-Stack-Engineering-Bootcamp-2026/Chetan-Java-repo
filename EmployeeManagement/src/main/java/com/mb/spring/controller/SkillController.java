package com.mb.spring.controller;

import java.time.LocalDateTime;
import java.util.List;

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
import com.mb.spring.dto.SkillRequestDto;
import com.mb.spring.dto.SkillResponseDto;
import com.mb.spring.service.SkillService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @PostMapping("/skills")
    public ResponseEntity<ApiResponse<SkillResponseDto>> create(
            @Valid @RequestBody SkillRequestDto dto) {

        SkillResponseDto skill = skillService.create(dto);

        ApiResponse<SkillResponseDto> response =
                new ApiResponse<>(201, "Skill created successfully", skill, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/skills")
    public ResponseEntity<ApiResponse<List<SkillResponseDto>>> getAll() {

        List<SkillResponseDto> skills = skillService.getAll();

        ApiResponse<List<SkillResponseDto>> response =
                new ApiResponse<>(200, "Skills fetched successfully", skills, LocalDateTime.now());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/skills/{id}")
    public ResponseEntity<ApiResponse<SkillResponseDto>> getById(@PathVariable Long id) {

        SkillResponseDto skill = skillService.getById(id);

        ApiResponse<SkillResponseDto> response =
                new ApiResponse<>(200, "Skill fetched successfully", skill, LocalDateTime.now());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/skills/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {

        skillService.deleteById(id);

        ApiResponse<Void> response =
                new ApiResponse<>(200, "Skill deleted successfully", null, LocalDateTime.now());

        return ResponseEntity.ok(response);
    }
}