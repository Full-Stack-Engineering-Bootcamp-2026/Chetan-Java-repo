package com.mb.spring.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mb.spring.dto.ProfileRequestDto;
import com.mb.spring.dto.ProfileResponseDto;
import com.mb.spring.entity.Profile;
import com.mb.spring.exception.UserNotFoundException;
import com.mb.spring.repo.ProfileRepository;

import lombok.RequiredArgsConstructor;
@Service
@Transactional
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ModelMapper modelMapper;

    public ProfileResponseDto create(ProfileRequestDto dto) {

        Profile profile = modelMapper.map(dto, Profile.class);
        Profile saved = profileRepository.save(profile);

        return modelMapper.map(saved, ProfileResponseDto.class);
    }

    
    public List<ProfileResponseDto> getAll() {
        return profileRepository.findAll()
                .stream()
                .map(profile -> modelMapper.map(profile, ProfileResponseDto.class))
                .toList();
    }


    public ProfileResponseDto getById(Long id) {

        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Profile not found"));

        return modelMapper.map(profile, ProfileResponseDto.class);
    }

    public void deleteById(Long id) {

        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Profile not found"));

        profileRepository.delete(profile);
    }
}