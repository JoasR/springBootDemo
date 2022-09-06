package com.example.demo.student.controllers;

import com.example.demo.student.entities.DTO.StudentDTO;
import com.example.demo.student.services.StudentService;
import com.example.demo.student.services.StudentServiceImpl;
import com.example.demo.student.entities.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        List<StudentDTO> allStudentsDTO = new ArrayList<>();
        for (Student student:allStudents) {
            StudentDTO studentDTO = new StudentDTO(student);
            allStudentsDTO.add(studentDTO);
        }
        return allStudentsDTO;
    }

    @GetMapping(path = "{studentId}")
    public StudentDTO getStudentById(@PathVariable("studentId") Long studentId){
        Optional<Student> getStudentById = studentService.getStudent(studentId);
        if (getStudentById.isPresent()){
         return new StudentDTO(getStudentById.get());
        } else {
            throw new IllegalStateException("Student with id: " + studentId + " does not exist");
        }
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }
}
