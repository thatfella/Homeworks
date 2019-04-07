package ru.otus.hw10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenreMainController {
    @GetMapping("/genres")
    public String welcome() {
        return "allGenres";
    }
}