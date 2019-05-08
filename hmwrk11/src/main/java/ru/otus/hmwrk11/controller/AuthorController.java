package ru.otus.hmwrk11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hmwrk11.dao.AuthorRepo;
import ru.otus.hmwrk11.model.Author;

@RestController
public class AuthorController {


    private AuthorRepo authorRepo;

    @Autowired
    public void setAuthorRepo(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping("/authors/{id}")
    public Mono<Author> getAuthor(@PathVariable long id) {
        return authorRepo.findById(id);
    }

    @PostMapping("/authors")
    public Mono<Author> addAuthorSubmit(@RequestBody Author author) {
        return authorRepo.save(author);
    }

    @PutMapping("/authors/{id}")
    public Mono<Author> editAuthorSubmit(@PathVariable long id, @RequestBody Author author) {
        return authorRepo.findById(id).map(existingAuthor -> {
            if (author.getName() != null) {
                existingAuthor.setName(author.getName());
            }
            return existingAuthor;
        }).then(authorRepo.save(author));
    }


    @GetMapping("/authors")
    public Flux<Author> allAuthors() {
        return authorRepo.findAll();
    }


    @DeleteMapping("/authors/{id}")
    public Mono<Void> deleteAuthor(@PathVariable long id) {
        return authorRepo.deleteById(id);
    }
}
