package com.mb.spring.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mb.spring.entity.EmpProfile;
import com.mb.spring.exception.UserNotFoundException;
import com.mb.spring.repo.ProfileRepo;

@Service
@Transactional
public class ProfileService {

	@Autowired
	private ProfileRepo repo;
	
	public EmpProfile create(EmpProfile profile) {
		return repo.save(profile);
	}

	public List<EmpProfile> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void deleteById(long id) {
		repo.findById(id).orElseThrow(()->new UserNotFoundException( "profile id does not exist for deleteById"));
		
	}

	public EmpProfile getById(long id) {
		// TODO Auto-generated method stub
		return  repo.findById(id).orElseThrow(()->new UserNotFoundException( "profile id does not exist for deleteById"));
		
	}
}
