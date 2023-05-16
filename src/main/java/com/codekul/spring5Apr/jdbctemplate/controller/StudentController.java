package com.codekul.spring5Apr.jdbctemplate.controller;

import com.codekul.spring5Apr.jdbctemplate.entity.Student;
import com.codekul.spring5Apr.jdbctemplate.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getStudentCount")
    public Integer getStudentCount(){
        return studentRepository.getStudentCount();

    }
    @PostMapping("/saveStudent")
    public String saveStudent(@RequestBody Student student){
        return studentRepository.saveStudent(student);
}
}