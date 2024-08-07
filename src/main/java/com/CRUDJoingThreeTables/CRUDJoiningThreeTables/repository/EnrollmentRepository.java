package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.repository;

import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    @Query("SELECT e FROM Enrollment e JOIN FETCH e.student s JOIN FETCH e.course c WHERE s.id = :studentId")
    List<Enrollment> findEnrollmentsByStudentId(@Param("studentId") Long studentId);
}


