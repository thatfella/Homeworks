package ru.otus.hw7.service;

import ru.otus.hw7.model.Book;

import java.util.List;

public interface BookService {
    void saveBook(int id, String name, int authorId, int genreId);
    Book getBook(int id);
    void deleteBook (int id);
    List<Book> getAllBooks();
    long count();
}
