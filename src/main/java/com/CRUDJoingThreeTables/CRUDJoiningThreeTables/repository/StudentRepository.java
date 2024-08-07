package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.repository;

import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

