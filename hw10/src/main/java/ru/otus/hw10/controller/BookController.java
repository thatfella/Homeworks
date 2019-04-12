package ru.otus.hw10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw10.model.Author;
import ru.otus.hw10.model.Book;
import ru.otus.hw10.model.Book;
import ru.otus.hw10.model.Genre;
import ru.otus.hw10.service.AuthorService;
import ru.otus.hw10.service.BookService;
import ru.otus.hw10.service.BookService;
import ru.otus.hw10.service.GenreService;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }



    @GetMapping("/books/{id}")
    public Book getBook(@RequestParam(value = "id") int id) {
        Book book = bookService.getBook(id);
        return book;
    }

    @PostMapping("/books")
    public Book addBookForm(@RequestBody Book book) {
        bookService.saveBook(book);
        return book;
    }

    @PutMapping("/books/{id}")
    public void editBookSubmit(@RequestParam(value = "id") int id, @RequestBody Book book) {
        bookService.editBook(book);
    }


    @GetMapping("/books")
    public List<Book> allBooks() {
        List<Book> books = bookService.getAllBooks();
        return books;
    }


    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable(value = "id") int id) {
        bookService.deleteBook(id);
    }

}
