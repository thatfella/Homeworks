package com.example.hw3.services;

import com.example.hw3.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    public StudentService(Student student) {
        this.student = student;
    }

    private Student student;

    public String greetStudent() {
        return "Hello " + student.getName();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
