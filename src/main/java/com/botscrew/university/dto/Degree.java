package com.botscrew.university.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "degree")
@Entity
public class Degree {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long degreeId;
    
}
