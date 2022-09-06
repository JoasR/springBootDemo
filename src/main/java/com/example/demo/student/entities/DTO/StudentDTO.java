package com.example.demo.student.entities.DTO;

import com.example.demo.student.entities.model.Student;

import java.time.LocalDate;

public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

    public StudentDTO() {
    }

    public StudentDTO(Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.dob = student.getDob();
        this.age = student.getAge();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
