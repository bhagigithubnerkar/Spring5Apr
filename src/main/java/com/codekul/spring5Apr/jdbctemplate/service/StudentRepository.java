package com.codekul.spring5Apr.jdbctemplate.service;


import com.codekul.spring5Apr.jdbctemplate.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    Integer getStudentCount();

    String saveStudent(Student student);

    String updateStudent(String phone,Integer rno);

    String deleteStudent(Integer rno);

    Student findByRno(Integer rno);

    List<Student> findAll();
}
