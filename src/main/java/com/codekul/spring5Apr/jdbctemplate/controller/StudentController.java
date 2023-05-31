package com.codekul.spring5Apr.jdbctemplate.controller;

import com.codekul.spring5Apr.jdbctemplate.entity.Student;
import com.codekul.spring5Apr.jdbctemplate.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getStudentCount")
    public Integer getStudentCount() {
        return studentRepository.getStudentCount();

    }

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestBody Student student) {
        return studentRepository.saveStudent(student);
    }

    @PutMapping("/updateStudent/{phone}/{rno}")
    public String updateStudent(@PathVariable String phone,
                                @PathVariable Integer rno) {
        return studentRepository.updateStudent(phone, rno);
    }

    @DeleteMapping("/deleteStudent")

    public String deleteStudent(@RequestParam Integer rno) {
        return studentRepository.deleteStudent(rno);

    }

    @GetMapping("/getStudentByRno/{rno}")
    public Student findStudentByRno(@PathVariable Integer rno) {
        return studentRepository.findByRno(rno);
    }
    @GetMapping("/getAllStudents")
    public List<Student> findAll(){
        return studentRepository.findAll();
    }


}


