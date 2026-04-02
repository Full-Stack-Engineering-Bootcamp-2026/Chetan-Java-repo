package com.mb.spring.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter

	public class Department {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long deptId;
	
	    @Column(name = "dept_name", unique = true)
	    private String deptName;
	}
