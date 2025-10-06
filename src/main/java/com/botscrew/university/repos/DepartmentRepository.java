package com.botscrew.university.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.botscrew.university.dto.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
}
