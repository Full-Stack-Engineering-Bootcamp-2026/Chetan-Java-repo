package com.mb.spring.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.spring.entity.Skill;


@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{

	Skill findBySkillName(String skillName);

}
