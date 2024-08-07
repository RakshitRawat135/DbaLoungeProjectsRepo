package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.controller;

import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Enrollment;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Student;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.model.DeleteFromSecondAndThirdTableById;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.model.ShowEnrollmentAndStudentTableById;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.model.UpdateStudents;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.service.CourseService;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.service.EnrollmentService;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RequestController {
    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

//    @DeleteMapping("/enrollmentsAndStudents")
//    public String deleteEnrollmentsAndStudents() {
//        enrollmentService.deleteAllEnrollments();
//        studentService.deleteAllStudents();
//        return "All enrollments and students have been deleted";
//    }

    @DeleteMapping("/delete/enrollmentsAndStudents")
    public String deleteEnrollmentsAndStudents(@RequestBody DeleteFromSecondAndThirdTableById deleteFromSecondAndThirdTableById) {
        enrollmentService.deleteById(deleteFromSecondAndThirdTableById.getEnrollmentId());
        studentService.deleteById(deleteFromSecondAndThirdTableById.getStudentId());
        return "Student and enrollment have been deleted";
    }

    @GetMapping("/show/enrollmentsAndStudents")
    public String showEnrollmentAndStudents(@RequestBody ShowEnrollmentAndStudentTableById showEnrollmentAndStudentTableById){
        Optional<Student> student = studentService.findById(showEnrollmentAndStudentTableById.getStudentId());
        Optional<Enrollment> enrollment = enrollmentService.findById(showEnrollmentAndStudentTableById.getEnrollmentId());
        if (student.isPresent() && enrollment.isPresent()) {
            return "Student: " + student.get() + "\nEnrollment: " + enrollment.get();
        } else {
            return "Student or Enrollment not found";
        }
    }

    @PutMapping("/updateStudents/{id}")
    public String updateStudents(@PathVariable Long id, @RequestBody UpdateStudents updateStudents){
        Optional<Student> existingStudent = studentService.findById(id);
        if(existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setName(updateStudents.getName());
            studentService.save(student);
            return "Student Details for "+id+ " updated";
        }else{
            return "customer details does not exist for id "+id;
        }
    }
}


