package com.example.demo.student.controllers;

import com.example.demo.student.services.StudentServiceImpl;
import com.example.demo.student.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentServiceImpl studentServiceImpl;

    @Autowired
    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentServiceImpl.getAllStudents();
    }

    @GetMapping(path = "{studentId}")
    public Optional<Student> getStudentById(@PathVariable("studentId") Long studentId){
        return studentServiceImpl.getStudent(studentId);
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentServiceImpl.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentServiceImpl.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentServiceImpl.updateStudent(studentId, name, email);
    }
}
