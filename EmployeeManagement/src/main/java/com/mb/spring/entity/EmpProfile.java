package com.mb.spring.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class EmpProfile {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long profile_id;
	
	private String address;
	
    @NotNull
    private Double salary;
    
   @NotNull
	private LocalDate hiredate;
}
