package com.botscrew.university.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "lector")
@Entity
public class Lector {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private int salary;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "degree_id")
    private Degree degree;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
