package com.botscrew.university.misc;

import java.util.List;

import org.springframework.stereotype.Component;

import com.botscrew.university.dto.Degree;
import com.botscrew.university.dto.Department;
import com.botscrew.university.dto.Lector;
import com.botscrew.university.dto.Role;
import com.botscrew.university.repos.DegreeRepository;
import com.botscrew.university.repos.DepartmentRepository;
import com.botscrew.university.repos.LectorRepository;

import jakarta.transaction.Transactional;

@Component
public class SampleData {

    private final DegreeRepository degreeRepository;
    private final LectorRepository lectorRepository;
    private final DepartmentRepository departmentRepository;

    public SampleData(DegreeRepository degreeRepository, LectorRepository lectorRepository, DepartmentRepository departmentRepository) {
        this.degreeRepository = degreeRepository;
        this.lectorRepository = lectorRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void generate() {
        Degree assistantDegree = new Degree();
        assistantDegree.setRole(Role.ASSISTANT);
        degreeRepository.save(assistantDegree);

        Degree assocProfDegree = new Degree();
        assocProfDegree.setRole(Role.ASSOCIATE_PROFESSOR);
        degreeRepository.save(assocProfDegree);

        Degree professorDegree = new Degree();
        professorDegree.setRole(Role.PROFESSOR);
        degreeRepository.save(professorDegree);

        Lector assistant = new Lector();
        assistant.setName("Bob Assistant");
        assistant.setSalary(45000);
        assistant.setDegree(assistantDegree);
        lectorRepository.save(assistant);

        Lector associateProf = new Lector();
        associateProf.setName("Jessy Associate");
        associateProf.setSalary(65000);
        associateProf.setDegree(assocProfDegree);
        lectorRepository.save(associateProf);

        Lector professor = new Lector();
        professor.setName("Dr. Evil");
        professor.setSalary(95000);
        professor.setDegree(professorDegree);
        lectorRepository.save(professor);

        Department department = new Department();
        department.setName("Mathematics");
        department.setLectors(List.of(assistant, associateProf, professor));
        department.setHead(professor); 
        departmentRepository.save(department);
    }
}
