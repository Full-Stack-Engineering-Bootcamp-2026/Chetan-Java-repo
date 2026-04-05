package com.mb.spring.service;

import java.util.List;

import com.mb.spring.dto.ProfileRequestDto;
import com.mb.spring.dto.ProfileResponseDto;
import com.mb.spring.entity.Profile;
import com.mb.spring.exception.UserNotFoundException;

public interface ProfileServiceInterface {

	public ProfileResponseDto create(ProfileRequestDto dto);

    public List<ProfileResponseDto> getAll() ;
    
    public ProfileResponseDto getById(Long id);

    public void deleteById(Long id);
}
