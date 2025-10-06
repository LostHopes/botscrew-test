package com.botscrew.university.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "department")
@Entity
public class Department {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.REFRESH)
    private List<Lector> lectors;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Lector head;

    public void setName(String name) {
        this.name = name;
    }

    public void setHead(Lector head) {
        this.head = head;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }
}
