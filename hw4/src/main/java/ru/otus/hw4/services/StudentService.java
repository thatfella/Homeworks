package ru.otus.hw4.services;

import org.springframework.stereotype.Component;
import ru.otus.hw4.model.Student;

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
