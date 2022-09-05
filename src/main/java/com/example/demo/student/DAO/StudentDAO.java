package com.example.demo.student.DAO;

import com.example.demo.student.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentDAO extends JpaRepository<Student, Long> {
    //@Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
