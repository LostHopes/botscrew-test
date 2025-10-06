package com.botscrew.university.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.botscrew.university.dto.Department;
import com.botscrew.university.dto.Lector;
import com.botscrew.university.dto.Role;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    @Query("SELECT d.head FROM Department d WHERE d.name = :depName")
    Optional<Lector> findDepartmentHead(@Param("depName") String depName);

    @Query("SELECT COUNT(l) FROM Department d JOIN d.lectors l WHERE d.name = :depName AND l.degree.role = :role")
    int countByRole(@Param("depName") String depName, @Param("role") Role role);


    @Query("SELECT AVG(l.salary) FROM Department d JOIN d.lectors l WHERE d.name = :depName")
    int calculateAvgSalary(@Param("depName") String depName);

    @Query("SELECT COUNT(l) FROM Department d JOIN d.lectors l WHERE d.name = :depName")
    int countEmployees(@Param("depName") String depName);

    @Query("SELECT l FROM Department d JOIN d.lectors l WHERE d.name = :depName AND l.name LIKE %:template%")
    List<Lector> searchLectorsByTemplate(@Param("depName") String depName, @Param("template") String template);


}
