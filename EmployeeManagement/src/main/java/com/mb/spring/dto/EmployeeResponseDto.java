package com.mb.spring.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeResponseDto {

    private Long id;

    private String name;

    private String email;

    private DepartmentResponseDto department;

    private ProfileResponseDto profile;

    private List<SkillResponseDto> skills;

}
