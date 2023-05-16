package com.codekul.spring5Apr.jdbctemplate.service.impl;

import com.codekul.spring5Apr.jdbctemplate.entity.Student;
import com.codekul.spring5Apr.jdbctemplate.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentRepositoryImpl implements StudentRepository {

    private final String studCount = "select count(*) from student;";

    private final String insertStudent = "insert into student(rno,name,age,city,phone,email) values(?,?,?,?,?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getStudentCount() {

        return jdbcTemplate.queryForObject(studCount, Integer.class);
    }

    @Override
    public String saveStudent(Student student) {
        try {
            jdbcTemplate.update(insertStudent, student.getRno(), student.getName(), student.getAge(), student.getCity(), student.getPhone(), student.getEmail());
            return "Student saved successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}


