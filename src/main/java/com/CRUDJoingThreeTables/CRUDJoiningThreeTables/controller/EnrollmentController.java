package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.controller;

import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Enrollment;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/show")
    public List<Enrollment> findAll() {
        return enrollmentService.findAll();
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) {
        Optional<Enrollment> enrollment = enrollmentService.findById(id);
        return enrollment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Enrollment save(@RequestBody Enrollment enrollment) {
        return enrollmentService.save(enrollment);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollmentDetails) {
        Optional<Enrollment> existingEnrollment = enrollmentService.findById(id);
        if (existingEnrollment.isPresent()) {
            Enrollment enrollment = existingEnrollment.get();
            enrollment.setGrade(enrollmentDetails.getGrade());
            Enrollment updatedEnrollment = enrollmentService.save(enrollment);
            return new ResponseEntity<>(updatedEnrollment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        enrollmentService.deleteById(id);
    }
}

