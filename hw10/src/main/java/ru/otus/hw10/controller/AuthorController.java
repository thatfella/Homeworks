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


    @GetMapping("/authors/{id}")
    public Author getAuthor(@RequestParam(value = "id") int id) {
        Author author = authorService.getAuthor(id);
        return author;
    }

    @PostMapping("/authors")
    public Author addAuthorForm(@RequestBody Author author) {
        authorService.saveAuthor(author.getAuthorid(), author.getAuthorname());
        return author;
    }

    @PutMapping("/authors/{id}")
    public void editAuthorSubmit(@RequestParam(value = "id") int id, @RequestBody Author author) {
        authorService.editAuthor(author);

    }


    @GetMapping("/authors")
    public List<Author> allAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return authors;
    }


    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable(value = "id") int id) {
        authorService.deleteAuthor(id);
    }
}
