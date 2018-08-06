package ru.otus.hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.hw2.service.LocalizeService;
import ru.otus.hw2.service.StudentService;
import ru.otus.hw2.service.TestChecker;

import java.util.Scanner;


@Component
public class AppBean {
    StudentService studentService;
    TestChecker checker;
    LocalizeService localize;

    @Autowired
    public AppBean(StudentService studentService, TestChecker checker, LocalizeService localize) {
        this.studentService = studentService;
        this.checker = checker;
        this.localize = localize;
    }


    public void launch() {
        System.out.println("Enter your name");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        studentService.getStudent().setName(name);
        System.out.println(studentService.greetStudent());
        localize.print();
        int[] studAnswers = checker.getStudentAnswers();
        checker.checkStudent(studAnswers);
    }

}
