package ru.otus.hw8.service;

import ru.otus.hw8.model.Book;

import java.util.List;

public interface BookService {
    void saveBook(long id, String name, long authorId, long genreId);
    Book getBook(long id);
    void deleteBook(long id);
    List<Book> getAllBooks();
    long count();
}
