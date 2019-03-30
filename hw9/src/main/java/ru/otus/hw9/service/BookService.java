package ru.otus.hw9.service;

import ru.otus.hw9.model.Book;

import java.util.List;

public interface BookService {
    void saveBook(int id, String name, int authorId, int genreId);
    Book getBook(int id);
    void deleteBook(int id);
    List<Book> getAllBooks();
    long count();
    void editBook(Book book);
}
