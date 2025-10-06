package com.botscrew.university.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.botscrew.university.dto.Lector;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    
}
