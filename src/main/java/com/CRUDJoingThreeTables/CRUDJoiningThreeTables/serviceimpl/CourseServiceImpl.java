package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.serviceimpl;

import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Course;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.repository.CourseRepository;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void deleteAll(){
        courseRepository.deleteAll();
    }
}

