package com.mb.spring.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpResDto {
	
	 	private Long id;
	    private String name;
	    private String email;
	    private Long deptId;
	    private List<SkillsDto> skills;

}
