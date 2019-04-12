package ru.otus.hw10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorMainController {

    @GetMapping("/author")
    public String welcome() {
        return "allAuthors";
    }
}
