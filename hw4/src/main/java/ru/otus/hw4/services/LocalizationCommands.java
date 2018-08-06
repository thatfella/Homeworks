package ru.otus.hw4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.hw4.model.Student;

@ShellComponent
public class LocalizationCommands {

    private LocalizeService localizeService;
    private Student student;
    private StudentService studentService;
    private TestChecker testChecker;

    @Autowired
    public LocalizationCommands(LocalizeService localizeService, Student student, StudentService studentService, TestChecker testChecker) {
        this.localizeService = localizeService;
        this.student = student;
        this.studentService = studentService;
        this.testChecker = testChecker;
    }

    @ShellMethod("Localize it EN")
    public void translate() {
         localizeService.printEN();
    }

    @ShellMethod("Localize it RU")
    public void localize() {
        localizeService.printRU();
    }

    @ShellMethod("Enter Name")
    public void introduce(@ShellOption String name) {
        student.setName(name);
        studentService.greetStudent();
    }

    @ShellMethod("Get And Check Answers")
    public void pass() {
      int answers[] = testChecker.getStudentAnswers();
      testChecker.checkStudent(answers);
    }

}
