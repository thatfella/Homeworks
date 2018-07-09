package ru.otus.hw1.service;

import ru.otus.hw1.model.Student;

public class StudentService {
    private Student studModel;

    public StudentService() {
    }

    public String greetStudent() {
        return "Hello " + studModel.getName();
    }

    public void setStudModel(Student studModel) {
        this.studModel = studModel;
    }

    public Student getStudModel() {
        return studModel;
    }
}
