package com.mb.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.spring.entity.EmpProfile;

@Repository
public interface ProfileRepo extends JpaRepository<EmpProfile, Long>{

}
