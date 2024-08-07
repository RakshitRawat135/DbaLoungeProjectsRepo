package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.serviceimpl;

import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Student;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.repository.StudentRepository;
import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}

