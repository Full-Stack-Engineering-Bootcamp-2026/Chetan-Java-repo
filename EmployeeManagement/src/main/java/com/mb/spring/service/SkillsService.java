package com.mb.spring.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mb.spring.entity.Skills;
import com.mb.spring.exception.UserNotFoundException;
import com.mb.spring.repo.SkillsRepo;

@Service
@Transactional
public class SkillsService {
	
	@Autowired
	private SkillsRepo repo;
	
	public Skills create(Skills skills) {
		return repo.save(skills);
	}

	public List<Skills> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	public void deleteById(long id) {
		repo.findById(id).orElseThrow(()->new UserNotFoundException("id does not exist"));
		repo.deleteById(id);
	}

	public Skills getById(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()->new UserNotFoundException("id does not exist"));
	}
}
