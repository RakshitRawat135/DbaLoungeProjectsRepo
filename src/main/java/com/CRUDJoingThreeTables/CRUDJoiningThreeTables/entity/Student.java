package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student")
    private Set<Enrollment> enrollments;

}
