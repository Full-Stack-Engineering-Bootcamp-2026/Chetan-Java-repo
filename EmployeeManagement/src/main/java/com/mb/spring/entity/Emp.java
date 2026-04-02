package com.mb.spring.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mb.spring.controller.ValidEmail;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "should not be blank")
    private String name;

    @ValidEmail
    private String email;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private EmpProfile profile;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;
    
    
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "employee_skills",joinColumns = @JoinColumn(name = "emp_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id"))
    
    private List<Skills> skills;
    
  
}