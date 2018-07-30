package ru.otus.hw2.model;

public class Test {
    private String id;
    private String question;
    private String firstAnswer;
    private String secondAnswer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    @Override
    public String toString() {
        return "Question= " + question + "\n" + "1) " + firstAnswer + "\n" + "2) " + secondAnswer + "\n";
    }
}
