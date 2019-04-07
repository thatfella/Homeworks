package ru.otus.hw10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw10.model.Author;
import ru.otus.hw10.service.AuthorService;

import java.util.List;

//@RequestMapping("/allAuthors")
@RestController
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("/author")
    public Author getAuthor(@RequestParam(value = "id") int id) {
        Author author = authorService.getAuthor(id);
        return author;
    }

    @PostMapping("/addauthor")
    public Author addAuthorForm(@RequestBody Author author) {
        authorService.saveAuthor(author.getAuthorid(), author.getAuthorname());
        return author;
    }

    @PutMapping("/editauthor")
    public void editAuthorSubmit(@RequestParam(value = "id") int id, @RequestBody Author author) {
        authorService.editAuthor(author);

    }


    @GetMapping("/all")
    public List<Author> allAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return authors;
    }


    @RequestMapping("/deleteAuthor")
    public String deleteAuthor(@RequestParam(value = "id") int id) {
        authorService.deleteAuthor(id);
        return "deleted";
    }
}
