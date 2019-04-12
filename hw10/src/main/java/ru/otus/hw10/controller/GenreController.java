package ru.otus.hw10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw10.model.Genre;
import ru.otus.hw10.service.GenreService;

import java.util.List;

@RestController
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres/{id}")
    public Genre getGenre(@RequestParam(value = "id") int id) {
        Genre genre = genreService.getGenre(id);
        return genre;
    }

    @PostMapping("/genres")
    public Genre addGenreForm(@RequestBody Genre genre) {
        genreService.saveGenre(genre.getGenreId(), genre.getGenreName());
        return genre;
    }

    @PutMapping("/genres/{id}")
    public void editGenreSubmit(@RequestParam(value = "id") int id, @RequestBody Genre genre) {
        genreService.editGenre(genre);
    }


    @GetMapping("/genres")
    public List<Genre> allGenres() {
        List<Genre> genres = genreService.getAllGenres();
        return genres;
    }


    @DeleteMapping("/genres/{id}")
    public void deleteGenre(@PathVariable(value = "id") int id) {
        genreService.deleteGenre(id);
    }
}
