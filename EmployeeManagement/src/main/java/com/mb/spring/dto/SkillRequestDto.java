package com.mb.spring.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter

public class SkillRequestDto {

    @NotBlank
    private String skillName;

    @NotBlank
    private String description;

}