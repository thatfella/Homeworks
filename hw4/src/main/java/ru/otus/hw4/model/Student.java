package ru.otus.hw4.model;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private String name;
    private int score;

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
