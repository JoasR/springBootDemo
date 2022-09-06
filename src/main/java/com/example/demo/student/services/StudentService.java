package com.example.demo.student.services;

import com.example.demo.student.entities.model.Student;


import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> getAllStudents();
    public Optional<Student> getStudent(Long studentId);
    public void addNewStudent(Student student);
    public void deleteStudent(Long studentId);
    public void updateStudent(Long studentId, String name, String email);
}
