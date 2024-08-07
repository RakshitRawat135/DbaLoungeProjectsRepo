package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.serviceimpl;

import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Enrollment;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.repository.EnrollmentRepository;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Optional<Enrollment> findById(Long id) {
        return enrollmentRepository.findById(id);
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);
    }

    public void deleteAllEnrollments() {
        enrollmentRepository.deleteAll();
    }
}

