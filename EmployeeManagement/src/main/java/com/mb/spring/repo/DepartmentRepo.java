package com.mb.spring.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.spring.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long>{

    Department findByDeptName(String deptName);

}
