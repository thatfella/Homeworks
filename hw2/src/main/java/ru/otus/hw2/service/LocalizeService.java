package ru.otus.hw2.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocalizeService {
    @Autowired
    private TestGetterService tg;

    public void print() {
        Locale [] locales = Locale.getAvailableLocales();
        for(Locale loc : locales) {
            System.out.println(loc);
        }
        Locale russian = Locale.getDefault();
        List<String> questions = new ArrayList<String>();
        questions.add(tg.messageSource().getMessage("q1", null, russian));
        questions.add(tg.messageSource().getMessage("q2", null, russian));
        questions.add(tg.messageSource().getMessage("q3", null, russian));
        questions.add(tg.messageSource().getMessage("q4", null, russian));
        questions.add(tg.messageSource().getMessage("q5", new Object[]{}, Locale.ENGLISH));
        display(questions);
        System.out.println(Locale.getDefault());
    }

    public void display(List<String> questions) {
        for (String iter : questions) {
            System.out.println(iter);
        }
    }
}