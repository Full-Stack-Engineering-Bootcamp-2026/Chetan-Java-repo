package com.mb.spring.service;

import java.util.List;

import com.mb.spring.dto.SkillRequestDto;
import com.mb.spring.dto.SkillResponseDto;
import com.mb.spring.entity.Skill;
import com.mb.spring.exception.UserNotFoundException;

public interface SkillServiceInterface {
	
	
	  public SkillResponseDto create(SkillRequestDto dto) ;
	  
	    public List<SkillResponseDto> getAll() ;
	    
	    public SkillResponseDto getById(Long id) ;

	    public void deleteById(Long id) ;
}


