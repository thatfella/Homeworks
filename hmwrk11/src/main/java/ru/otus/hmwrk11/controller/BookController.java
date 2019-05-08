package ru.otus.hmwrk11.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hmwrk11.dao.BookRepo;
import ru.otus.hmwrk11.model.Book;

@RestController
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/books/{id}")
    public Mono<Book> getBook(@PathVariable long id) {
        return bookRepo.findById(id);
    }

    @PostMapping("/books")
    public Mono<Book> addBookSubmit(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    @PutMapping("/books/{id}")
    public Mono<Book> editBookSubmit(@PathVariable long id, @RequestBody Book book) {
        return bookRepo.findById(id).map(existingBook -> {
            if (book.getName() != null) {
                existingBook.setName(book.getName());
            }
            return existingBook;
        }).then(bookRepo.save(book));
    }


    @GetMapping("/books")
    public Flux<Book> allBooks() {
        return bookRepo.findAll();
    }


    @DeleteMapping("/books/{id}")
    public Mono<Void> deleteBook(@PathVariable long id) {
        return bookRepo.deleteById(id);
    }
}
