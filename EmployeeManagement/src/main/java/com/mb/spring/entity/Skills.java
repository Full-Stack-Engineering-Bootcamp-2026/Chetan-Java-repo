package com.mb.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Skills {
	
	@Id   
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "skill_name", unique = true)
	private String skillName;
	
	@NotBlank
	private String description;
	
	
	
}
