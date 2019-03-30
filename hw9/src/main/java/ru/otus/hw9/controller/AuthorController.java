package ru.otus.hw9.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw9.model.Author;
import ru.otus.hw9.service.AuthorService;

import java.util.List;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("/author")
    public String getAuthor(@RequestParam(value = "id") int id, Model model) {
        Author author = authorService.getAuthor(id);
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
        authorService.saveAuthor(author.getAuthorid(), author.getAuthorname());
        return "added";
    }

    @GetMapping("/editauthor")
    public String editAuthor(@RequestParam(value = "id") int id, Model model) {
        Author author = authorService.getAuthor(id);
        model.addAttribute("author", author);
        return "editAuthor";
    }

    @PostMapping("/editauthor")
    public String editAuthorSubmit(@ModelAttribute Author author) {
        authorService.editAuthor(author);
        return "getAuthor";
    }

    @GetMapping("/allAuthors")
    public String allAuthors(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        System.out.println(authors);
        return "allAuthors";
    }

    @RequestMapping("/deleteAuthor")
    public String deleteAuthor(@RequestParam(value = "id") int id) {
        authorService.deleteAuthor(id);
        return "deleted";
    }
}
