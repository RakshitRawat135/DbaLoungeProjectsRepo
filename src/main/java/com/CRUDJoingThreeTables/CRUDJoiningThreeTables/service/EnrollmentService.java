package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.service;

import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Enrollment;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Student;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    List<Enrollment> findAll();
    Optional<Enrollment> findById(Long id);
    Enrollment save(Enrollment enrollment);
    void deleteById(Long id);
    void deleteAllEnrollments();
}
