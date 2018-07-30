package ru.otus.hw2.model;

import org.springframework.stereotype.Component;

@Component
public class Answers {

    private static final int[] CORRECT_ANSWERS = {1, 2, 1, 1, 2};

    public static int[] getCorrectAnswers() {
        return CORRECT_ANSWERS;
    }
}
