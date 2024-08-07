package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.service;

import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> findAll();
    public Optional<Student> findById(Long id);
    public Student save(Student student);
    public void deleteById(Long id);
    void deleteAllStudents();
}
