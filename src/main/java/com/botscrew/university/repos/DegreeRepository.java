package com.botscrew.university.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.botscrew.university.dto.Degree;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {
    
}
