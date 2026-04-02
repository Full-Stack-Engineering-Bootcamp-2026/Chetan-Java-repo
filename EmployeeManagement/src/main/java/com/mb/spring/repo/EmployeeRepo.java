package com.mb.spring.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mb.spring.entity.Emp;

@Repository
public interface EmployeeRepo extends JpaRepository<Emp, Long>{

	
//	@Query("SELECT e FROM Emp e JOIN e.skills s WHERE s.skillName = :skill")
//    List<Emp> findEmployeesBySkill(@Param("skill") String skill);
//	
	
//	 @NativeQuery("select * from Emp e join skills s on e.emp_id=s.skill_id where s.skillName=:skill")
//	 List<Emp> findEmployeesBySkill(@Param("skill") String skill);
//	 
//	

}
