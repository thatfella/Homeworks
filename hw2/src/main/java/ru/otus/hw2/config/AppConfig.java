package ru.otus.hw2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.hw2.model.Answers;
import ru.otus.hw2.model.Student;
import ru.otus.hw2.model.Test;
import ru.otus.hw2.service.LocalizeService;
import ru.otus.hw2.service.StudentService;
import ru.otus.hw2.service.TestChecker;
import ru.otus.hw2.service.TestGetterService;

@Configuration
public class AppConfig {

    @Bean
    public Student student() {
        return new Student();
    }

    @Bean
    public Test test() {
        return new Test();
    }

    @Bean
    public Answers answers() {
        return new Answers();
    }

    @Bean
    public StudentService studentService() {
        return new StudentService(student());
    }

    @Bean
    public TestChecker testChecker() {
        return new TestChecker(student());
    }

    @Bean
    public LocalizeService localizeService() {
        return new LocalizeService();
    }

    @Bean
    public TestGetterService messageService() {
        return new TestGetterService();
    }

}
