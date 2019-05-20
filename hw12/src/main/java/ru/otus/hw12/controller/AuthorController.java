package ru.otus.hw12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw12.model.Author;
import ru.otus.hw12.service.AuthorRepo;

import java.util.List;

@Controller
public class AuthorController {

    private AuthorRepo authorRepo;

    @Autowired
    public AuthorController(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping("/author")
    public String getAuthor(@RequestParam(value = "id") long id, Model model) {
        Author author = (Author) authorRepo.findById(id).get();
        model.addAttribute("author", author);
        return "getAuthor";
    }

    @GetMapping("/addauthor")
    public String addAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("/addauthor")
    public String addAuthorSubmit(@ModelAttribute Author author) {
        authorRepo.save(author);
        return "added";
    }

    @GetMapping("/editauthor")
    public String editAuthor(@RequestParam(value = "id") long id, Model model) {
        Author author = authorRepo.findById(id).orElse(null);
        model.addAttribute("author", author);
        return "editAuthor";
    }

    @PostMapping("/editauthor")
    public String editAuthorSubmit(@ModelAttribute Author author) {
        authorRepo.save(author);
        return "getAuthor";
    }

    @GetMapping("/allAuthors")
    public String allAuthors(Model model) {
        List<Author> authors = authorRepo.findAll();
        model.addAttribute("authors", authors);
        System.out.println(authors);
        return "allAuthors";
    }

    @RequestMapping("/deleteAuthor")
    public String deleteAuthor(@RequestParam(value = "id") long id) {
        authorRepo.deleteById(id);
        return "deleted";
    }

}
