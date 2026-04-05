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
import com.mb.spring.dto.ProfileRequestDto;
import com.mb.spring.dto.ProfileResponseDto;
import com.mb.spring.entity.Department;
import com.mb.spring.entity.Profile;
import com.mb.spring.service.ProfileService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/profiles")
    public ResponseEntity<ApiResponse<ProfileResponseDto>> create(
            @Valid @RequestBody ProfileRequestDto dto) {

        ProfileResponseDto profile = profileService.create(dto);

        ApiResponse<ProfileResponseDto> response =
                new ApiResponse<>(201, "Profile created successfully", profile, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/profiles")
    public ResponseEntity<ApiResponse<List<ProfileResponseDto>>> getAll() {

        List<ProfileResponseDto> profiles = profileService.getAll();

        ApiResponse<List<ProfileResponseDto>> response =
                new ApiResponse<>(200, "Profiles fetched successfully", profiles, LocalDateTime.now());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/profiles/{id}")
    public ResponseEntity<ApiResponse<ProfileResponseDto>> getById(@PathVariable Long id) {

        ProfileResponseDto profile = profileService.getById(id);

        ApiResponse<ProfileResponseDto> response =
                new ApiResponse<>(200, "Profile fetched successfully", profile, LocalDateTime.now());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {

        profileService.deleteById(id);

        ApiResponse<Void> response =
                new ApiResponse<>(200, "Profile deleted successfully", null, LocalDateTime.now());

        return ResponseEntity.ok(response);
    }
}