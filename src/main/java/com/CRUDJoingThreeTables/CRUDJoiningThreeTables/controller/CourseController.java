package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.controller;

import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Course;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/show")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.findById(id);

        if (course.isPresent()) {
            return ResponseEntity.ok(course.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public String createEntry(@RequestBody Course course) {
        courseService.save(course);
        return "Entry is created";
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        Optional<Course> existingCourse = courseService.findById(id);
        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();
            course.setName(courseDetails.getName());
            Course updatedCourse = courseService.save(course);
            return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        courseService.deleteAll();
    }
}

