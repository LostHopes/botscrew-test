package com.botscrew.university.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "degree")
@Entity
public class Degree {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Role role;

    @OneToOne
    @JoinColumn(name = "lector_id")
    private Lector lector;
}
