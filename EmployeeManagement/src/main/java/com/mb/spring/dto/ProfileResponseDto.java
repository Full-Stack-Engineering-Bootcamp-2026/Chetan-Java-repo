package com.mb.spring.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProfileResponseDto {

    private Long id;

    private String address;

    private Double salary;

    private LocalDate hireDate;

}
