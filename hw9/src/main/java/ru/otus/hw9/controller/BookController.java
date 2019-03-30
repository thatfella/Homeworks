package ru.otus.hw9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw9.model.Author;
import ru.otus.hw9.model.Book;
import ru.otus.hw9.model.Genre;
import ru.otus.hw9.service.AuthorService;
import ru.otus.hw9.service.BookService;
import ru.otus.hw9.service.GenreService;

import java.util.List;

@Controller
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



    @GetMapping("/book")
    public String getBook(@RequestParam(value = "id") int id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "getBook";
    }

    @GetMapping("/addbook")
    public String addAuthorForm(Model model) {
        model.addAttribute("book", new Book());
        List<Author> authorList = authorService.getAllAuthors();
        List<Genre> genreList = genreService.getAllGenres();
        model.addAttribute("authors", authorList);
        model.addAttribute("genres",genreList);
        return "addBook";
    }

    @PostMapping("/addbook")
    public String addAuthorSubmit(@ModelAttribute Book book) {
        bookService.saveBook(book.getId(),book.getName(),book.getAuthor().getAuthorid(), book.getGenre().getGenreId());
        return "added";
    }

    @GetMapping("/allBooks")
    public String allBooks (Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "allBooks";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam(value = "id") int id) {
        bookService.deleteBook(id);
        return "deleted";
    }

    @GetMapping("/editbook")
    public String editAuthor(@RequestParam(value = "id") int id, Model model) {
        List<Author> authorList = authorService.getAllAuthors();
        List<Genre> genreList = genreService.getAllGenres();
        model.addAttribute("authors", authorList);
        model.addAttribute("genres",genreList);
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "editBook";
    }

    @PostMapping("/editbook")
    public String editAuthorSubmit(@ModelAttribute Book book) {
        bookService.editBook(book);
        return "getBook";
    }

}
