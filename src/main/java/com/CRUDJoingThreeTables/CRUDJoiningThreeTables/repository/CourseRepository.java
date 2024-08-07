package com.CRUDJoingThreeTables.CRUDJoiningThreeTables.repository;

import com.CRUDJoingThreeTables.CRUDJoiningThreeTables.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {


}
