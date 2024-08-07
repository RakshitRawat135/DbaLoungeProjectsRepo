package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.service;

import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public List<Course> findAll();
    public Optional<Course> findById(Long id);
    public Course save(Course course);
    public void deleteById(Long id);
    public void deleteAll();
}
