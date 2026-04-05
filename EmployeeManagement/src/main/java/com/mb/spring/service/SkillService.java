package com.mb.spring.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mb.spring.dto.SkillRequestDto;
import com.mb.spring.dto.SkillResponseDto;
import com.mb.spring.entity.Skill;
import com.mb.spring.exception.UserNotFoundException;
import com.mb.spring.repo.SkillRepository;

import lombok.RequiredArgsConstructor;
@Service
@Transactional
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;
    private final ModelMapper modelMapper;

    public SkillResponseDto create(SkillRequestDto dto) {

        Skill skill = modelMapper.map(dto, Skill.class);
        Skill saved = skillRepository.save(skill);

        return modelMapper.map(saved, SkillResponseDto.class);
    }

 
    public List<SkillResponseDto> getAll() {
        return skillRepository.findAll()
                .stream()
                .map(skill -> modelMapper.map(skill, SkillResponseDto.class))
                .toList();
    }

 
    public SkillResponseDto getById(Long id) {

        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Skill not found"));

        return modelMapper.map(skill, SkillResponseDto.class);
    }

    public void deleteById(Long id) {

        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Skill not found"));

        skillRepository.delete(skill);
    }
}