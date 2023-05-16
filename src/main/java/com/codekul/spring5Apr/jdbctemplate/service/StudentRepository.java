package com.codekul.spring5Apr.jdbctemplate.service;


import com.codekul.spring5Apr.jdbctemplate.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {
    Integer getStudentCount();

    String saveStudent(Student student);
}
