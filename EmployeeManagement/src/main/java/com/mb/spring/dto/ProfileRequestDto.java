package com.mb.spring.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter

public class ProfileRequestDto {

    private String address;

    @NotNull
    @Positive
    private Double salary;

    @NotNull
    private LocalDate hireDate;

}