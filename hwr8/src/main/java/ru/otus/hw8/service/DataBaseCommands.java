package ru.otus.hw8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw8.model.Author;
import ru.otus.hw8.model.Book;
import ru.otus.hw8.model.Comment;
import ru.otus.hw8.model.Genre;


@ShellComponent
public class DataBaseCommands {

    private AuthorService authorService;
    private BookService bookService;
    private GenreService genreService;
    private CommentService commentService;

    @Autowired
    public DataBaseCommands(AuthorService authorService, BookService bookService, GenreService genreService, CommentService commentService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.genreService = genreService;
        this.commentService = commentService;
    }

    @ShellMethod("insert Author")
    public void insertAuthor(int id, String name) {
        authorService.saveAuthor(id, name);
    }

    @ShellMethod("insertGenre")
    public void insertGenre(int id, String name) {
        genreService.saveGenre(id, name);
    }


    @ShellMethod("getAuthors")
    public void getAllAuthors() {
        authorService.getAllAuthors();
    }

    @ShellMethod("findAuthor")
    public Author findAuthor(int id) {
        return authorService.getAuthor(id);
    }

    @ShellMethod("find genre")
    public Genre findGenre(int id) {
        return genreService.getGenre(id);
    }

    @ShellMethod("insert book")
    public void insertBook(int bookId, String bookname, int authorId, int genreId) {
        bookService.saveBook(bookId, bookname, authorId, genreId);
    }

    @ShellMethod("find book")
    public Book findBook(int id) {
        return bookService.getBook(id);
    }

    @ShellMethod("find comment")
    public Comment findComment(int id) {
        return commentService.getComment(id);
    }

    @ShellMethod("insert comment")
    public void addComment(String text, int bookId) {
        commentService.saveComment(text, bookId);
    }

    @ShellMethod("delete author")
    public void deleteAuthor(int id) {
        authorService.deleteAuthor(id);
    }

    @ShellMethod("delete genre")
    public void deleteGenre(int id) {
        genreService.deleteGenre(id);
    }

    @ShellMethod("delete comment")
    public void deleteComment(int id) {
        commentService.deleteComment(id);
    }

    @ShellMethod("delete book")
    public void deleteBook(int id) {
        bookService.deleteBook(id);
    }

    @ShellMethod("comments to book")
    public void getCommentsToBook(int id) {
        System.out.println(commentService.getAllCommentByBookId(id).toString());
    }
}
