package ru.otus.hw12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw12.model.Author;
import ru.otus.hw12.model.Book;
import ru.otus.hw12.model.Genre;
import ru.otus.hw12.service.AuthorRepo;
import ru.otus.hw12.service.BookRepo;
import ru.otus.hw12.service.GenreRepo;

import java.util.List;

@Controller
public class BookController {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final GenreRepo genreRepo;

    @Autowired
    public BookController(BookRepo bookRepo, AuthorRepo authorRepo, GenreRepo genreRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.genreRepo = genreRepo;
    }



    @GetMapping("/book")
    public String getBook(@RequestParam(value = "id") long id, Model model) {
        Book book = bookRepo.findById(id).get();
        model.addAttribute("book", book);
        return "getBook";
    }

    @GetMapping("/addbook")
    public String addAuthorForm(Model model) {
        model.addAttribute("book", new Book());
        List<Author> authorList = authorRepo.findAll();
        List<Genre> genreList = genreRepo.findAll();
        model.addAttribute("authors", authorList);
        model.addAttribute("genres",genreList);
        return "addBook";
    }

    @PostMapping("/addbook")
    public String addAuthorSubmit(@ModelAttribute Book book) {
        bookRepo.save(new Book(book.getId(),book.getName(),book.getAuthor().getId(), book.getGenre().getId()));
        return "added";
    }

    @GetMapping("/allBooks")
    public String allBooks (Model model) {
        List<Book> books = bookRepo.findAll();
        model.addAttribute("books", books);
        return "allBooks";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam(value = "id") long id) {
        bookRepo.deleteById(id);
        return "deleted";
    }

    @GetMapping("/editbook")
    public String editAuthor(@RequestParam(value = "id") long id, Model model) {
        List<Author> authorList = authorRepo.findAll();
        List<Genre> genreList = genreRepo.findAll();
        model.addAttribute("authors", authorList);
        model.addAttribute("genres",genreList);
        Book book = bookRepo.findById(id).get();
        model.addAttribute("book", book);
        return "editBook";
    }

    @PostMapping("/editbook")
    public String editAuthorSubmit(@ModelAttribute Book book) {
        bookRepo.save(book);
        return "getBook";
    }

}
