package ru.otus.hw4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class LocalizeService {
    @Autowired
    private TestGetterService tg;

    public void printRU() {
        Locale russian = Locale.getDefault();
        List<String> questions = new ArrayList<String>();
        questions.add(tg.messageSource().getMessage("q1", null, russian));
        questions.add(tg.messageSource().getMessage("q2", null, russian));
        questions.add(tg.messageSource().getMessage("q3", null, russian));
        questions.add(tg.messageSource().getMessage("q4", null, russian));
        questions.add(tg.messageSource().getMessage("q5", null, russian));
        display(questions);
    }

    public void printEN() {

        List<String> questions = new ArrayList<String>();
        questions.add(tg.messageSource().getMessage("q1", null, Locale.ENGLISH));
        questions.add(tg.messageSource().getMessage("q2", null, Locale.ENGLISH));
        questions.add(tg.messageSource().getMessage("q3", null, Locale.ENGLISH));
        questions.add(tg.messageSource().getMessage("q4", null, Locale.ENGLISH));
        questions.add(tg.messageSource().getMessage("q5", null, Locale.ENGLISH));
        display(questions);
    }


    public void display(List<String> questions) {
        for (String iter : questions) {
            System.out.println(iter);
        }
    }
}