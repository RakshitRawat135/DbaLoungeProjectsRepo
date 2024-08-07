package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.controller;

import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Student;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/show")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Optional<Student> existingStudent = studentService.findById(id);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setName(studentDetails.getName());
            Student updatedStudent = studentService.save(student);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}

