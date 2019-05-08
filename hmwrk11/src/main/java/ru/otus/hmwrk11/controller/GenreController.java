package ru.otus.hmwrk11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hmwrk11.dao.GenreRepo;
import ru.otus.hmwrk11.model.Genre;

@RestController
public class GenreController {

    private GenreRepo genreRepo;

    @Autowired
    public void setGenreRepo(GenreRepo genreRepo) {
        this.genreRepo = genreRepo;
    }

    @GetMapping("/genres/{id}")
    public Mono<Genre> getGenre(@PathVariable long id) {
        return genreRepo.findById(id);
    }

    @PostMapping("/genres")
    public Mono<Genre> addGenreSubmit(@RequestBody Genre genre) {
        return genreRepo.save(genre);
    }

    @PutMapping("/genres/{id}")
    public Mono<Genre> editGenreSubmit(@PathVariable long id, @RequestBody Genre genre) {
        return genreRepo.findById(id).map(existingGenre -> {
            if (genre.getGenreName() != null) {
                existingGenre.setGenreName(genre.getGenreName());
            }
            return existingGenre;
        }).then(genreRepo.save(genre));
    }


    @GetMapping("/genres")
    public Flux<Genre> allGenres() {
        return genreRepo.findAll();
    }


    @DeleteMapping("/genres/{id}")
    public Mono<Void> deleteGenre(@PathVariable long id) {
        return genreRepo.deleteById(id);
    }
}
