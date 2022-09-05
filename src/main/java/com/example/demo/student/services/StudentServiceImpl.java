package com.example.demo.student.services;

import com.example.demo.student.models.Student;
import com.example.demo.student.DAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> getAllStudents(){
        return studentDAO.findAll();
    }

    @Override
    public Optional<Student> getStudent(Long studentId) {
        Optional<Student> student = studentDAO.findById(studentId);
        if (!student.isPresent()){
            throw new IllegalStateException("Student with the ID: " + studentId + " does not exist");
        }
        return student;
    }

    public void addNewStudent(Student student) {
        Optional<Student> optionalStudent = studentDAO.findStudentByEmail(student.getEmail());
        if (optionalStudent.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentDAO.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentDAO.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        studentDAO.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentDAO.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "student with id " + studentId + " does not exist."
        ));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentDAO.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Email is already taken");
            }
            student.setEmail(email);
        }
    }
}
