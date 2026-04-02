package com.mb.spring.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.spring.entity.Skills;


@Repository
public interface SkillsRepo extends JpaRepository<Skills, Long>{

	Skills findBySkillName(String skillName);

}
