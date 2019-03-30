package ru.otus.hw9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw9.model.Author;
import ru.otus.hw9.model.Genre;
import ru.otus.hw9.service.AuthorService;
import ru.otus.hw9.service.GenreService;

import java.util.List;

@Controller
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genre")
    public String getAuthor(@RequestParam(value = "id") int id, Model model) {
        Genre genre = genreService.getGenre(id);
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
        genreService.saveGenre(genre.getGenreId(), genre.getGenreName());
        return "added";
    }

    @GetMapping("/allGenres")
    public String allAuthors (Model model) {
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("genres", genres);
        System.out.println(genres);
        return "allGenres";
    }

    @RequestMapping("/deleteGenre")
    public String deleteGenre(@RequestParam(value = "id") int id) {
        genreService.deleteGenre(id);
        return "deleted";
    }

    @GetMapping("/editgenre")
    public String editAuthor(@RequestParam(value = "id") int id, Model model) {
        Genre genre = genreService.getGenre(id);
        model.addAttribute("genre", genre);
        return "editGenre";
    }

    @PostMapping("/editgenre")
    public String editAuthorSubmit(@ModelAttribute Genre genre) {
        genreService.editGenre(genre);
        return "getGenre";
    }
}
