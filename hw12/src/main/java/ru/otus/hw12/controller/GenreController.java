package ru.otus.hw12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw12.service.GenreRepo;
import ru.otus.hw12.model.Genre;

import java.util.List;

@Controller
public class GenreController {

    private final GenreRepo genreRepo;

    @Autowired
    public GenreController(GenreRepo genreRepo) {
        this.genreRepo = genreRepo;
    }

    @GetMapping("/genre")
    public String getAuthor(@RequestParam(value = "id") long id, Model model) {
        Genre genre = genreRepo.findById(id).get();
        model.addAttribute("genre", genre);
        return "getGenre";
    }

    @GetMapping("/addgenre")
    public String addGenreForm(Model model) {
        model.addAttribute("genre", new Genre());
        return "addGenre";
    }

    @PostMapping("/addgenre")
    public String addGenreSubmit(@ModelAttribute Genre genre) {
        genreRepo.insert(genre);
        return "added";
    }

    @GetMapping("/allGenres")
    public String allAuthors(Model model) {
        List<Genre> genres = genreRepo.findAll();
        model.addAttribute("genres", genres);
        System.out.println(genres);
        return "allGenres";
    }

    @RequestMapping("/deleteGenre")
    public String deleteGenre(@RequestParam(value = "id") long id) {
        genreRepo.deleteById(id);
        return "deleted";
    }

    @GetMapping("/editgenre")
    public String editAuthor(@RequestParam(value = "id") long id, Model model) {
        Genre genre = genreRepo.findById(id).orElse(null);
        model.addAttribute("genre", genre);
        return "editGenre";
    }

    @PostMapping("/editgenre")
    public String editAuthorSubmit(@ModelAttribute Genre genre) {
        genreRepo.save(genre);
        return "getGenre";
    }
}
