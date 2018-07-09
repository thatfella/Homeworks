package ru.otus.hw1.service;

import ru.otus.hw1.model.Answers;
import ru.otus.hw1.model.Student;

import java.util.Scanner;

public class TestChecker {
    private Answers correctAnswers;
    private Student student;

    public int[] getStudentAnswers() {
        int answersToQuestions[] = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println(" Input your option as an answer to question " + i);
            Scanner answerScanner = new Scanner(System.in);
            int answer = answerScanner.nextInt();
            answersToQuestions[i] = answer;
        }
        return answersToQuestions;
    }

    public int checkStudent(int[] studentAnswers) {
        int correctCounter = 0;
        for (int i = 0; i < 5; i++) {
            if (Answers.getCorrectAnswers()[i] == studentAnswers[i]) {
                correctCounter++;
            }
        }
        System.out.println("Thanks for passing test " + student.getName() + "\n Your result is " + correctCounter + " of 5");
        return correctCounter;
    }

    public void setCorrectAnswers(Answers correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public Answers getCorrectAnswers() {
        return correctAnswers;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}
