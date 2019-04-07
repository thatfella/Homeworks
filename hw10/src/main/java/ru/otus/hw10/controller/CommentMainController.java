package ru.otus.hw10.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentMainController {

    @GetMapping("/comments")
    public String welcome() {
        return "allComments";
    }
}

