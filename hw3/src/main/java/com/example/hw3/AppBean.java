package com.example.hw3;

import com.example.hw3.services.ParserService;
import com.example.hw3.services.StudentService;
import com.example.hw3.services.TestChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class AppBean {

    @Autowired
    ParserService parserService;
    @Autowired
    StudentService studentService;
    @Autowired
    TestChecker checker;

    public void execute () {
        System.out.println("Enter your name");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        studentService.getStudent().setName(name);
        System.out.println(studentService.greetStudent());
        try {
            parserService.getTestQuestions();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] studAnswers = checker.getStudentAnswers();
        checker.checkStudent(studAnswers);
    }

    }

