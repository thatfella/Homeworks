package ru.otus.hw2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.hw2.config.AppConfig;
import ru.otus.hw2.service.LocalizeService;
import ru.otus.hw2.service.StudentService;
import ru.otus.hw2.service.TestChecker;

import java.io.IOException;
import java.util.Scanner;

@Configuration
@ComponentScan (basePackages = "ru.otus")
public class Main {

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService studentService = context.getBean(StudentService.class);
        LocalizeService localize = context.getBean(LocalizeService.class);
        TestChecker checker = context.getBean(TestChecker.class);
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
