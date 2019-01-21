package ru.otus.hw5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw5.dao.impl.AuthorRepositoryJdbc;
import ru.otus.hw5.dao.impl.BookRepositoryJdbc;
import ru.otus.hw5.dao.impl.GenreRepositoryJdbc;
import ru.otus.hw5.model.Author;
import ru.otus.hw5.model.Book;
import ru.otus.hw5.model.Genre;

@ShellComponent
public class DataBaseCommands {

    private AuthorRepositoryJdbc authorRepositoryJdbc;
    private GenreRepositoryJdbc genreRepositoryJdbc;
    private BookRepositoryJdbc bookRepositoryJdbc;

    @Autowired
    public DataBaseCommands(AuthorRepositoryJdbc authorRepositoryJdbc, GenreRepositoryJdbc genreRepositoryJdbc, BookRepositoryJdbc bookRepositoryJdbc) {
        this.authorRepositoryJdbc = authorRepositoryJdbc;
        this.genreRepositoryJdbc = genreRepositoryJdbc;
        this.bookRepositoryJdbc = bookRepositoryJdbc;
    }

    @ShellMethod("insert Author")
    public void insertAuthor(int id,  String name) {
        authorRepositoryJdbc.insertAuthor(new Author(id, name));
    }

    @ShellMethod("insertGenre")
    public void insertGenre(int id, String name) {
        genreRepositoryJdbc.insert(new Genre(id, name));
    }

    @ShellMethod("findAuthor")
    public Author findAuthor(int id) {
        return authorRepositoryJdbc.findAuthorById(id);
    }

    @ShellMethod("find genre")
    public Genre findGenre(int id) {
        return genreRepositoryJdbc.findGenreById(id);
    }

    @ShellMethod("insert book")
    public void insertBook(int bookId, String bookname, int authorId, int genreId) {
        bookRepositoryJdbc.insertBook(new Book(bookId,bookname,authorId,genreId));
    }

    @ShellMethod("find book")
    public Book findBook(int id) {
        return bookRepositoryJdbc.findBookById(id);
    }

}
