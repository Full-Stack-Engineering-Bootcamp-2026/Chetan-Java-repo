package com.mb.spring.dto;

import java.util.List;

import com.mb.spring.entity.Department;
import com.mb.spring.entity.Profile;
import com.mb.spring.entity.Skill;
import com.mb.spring.util.ValidEmail;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto {

    @NotBlank
    private String name;

    @ValidEmail
    @NotBlank
    private String email;

    private Department department;

    private Profile profile;

    private List<Skill> skills;
}