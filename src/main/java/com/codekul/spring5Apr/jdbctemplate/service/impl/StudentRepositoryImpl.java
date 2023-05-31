package com.codekul.spring5Apr.jdbctemplate.service.impl;

import com.codekul.spring5Apr.jdbctemplate.entity.Student;
import com.codekul.spring5Apr.jdbctemplate.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRepositoryImpl implements StudentRepository {

    private final String studCount = "select count(*) from student;";

    private final String insertStudent = "insert into student(rno,name,age,city,email,phone) values(?,?,?,?,?,?)";

    private final String updateStudent = "update student set phone = ? where rno = ?";

    private final String deleteStudent = "delete from student where rno = ?";

    private final String findByRno = "Select * from student where rno = ?";

    private final String fetchAll = "Select * from student";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getStudentCount() {

        return jdbcTemplate.queryForObject(studCount, Integer.class);
    }

    @Override
    public String saveStudent(Student student) {
        try {
            jdbcTemplate.update(insertStudent, student.getRno(), student.getName(), student.getAge(), student.getCity(), student.getEmail(), student.getPhone());
            return "Student saved successfully";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public String updateStudent(String phone, Integer rno) {
        try {
            jdbcTemplate.update(updateStudent, phone, rno);
            return "Student updated successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteStudent(Integer rno) {
        try {
            jdbcTemplate.update(deleteStudent, rno);
            return "Student deleted successfully";
        } catch (Exception e) {
            return e.getMessage();

        }

    }

    @Override
    public Student findByRno(Integer rno) {
        return jdbcTemplate.queryForObject(findByRno, BeanPropertyRowMapper.newInstance(Student.class),rno);
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query(fetchAll,BeanPropertyRowMapper.newInstance(Student.class));
    }


}



