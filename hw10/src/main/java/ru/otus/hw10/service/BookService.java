package ru.otus.hw10.service;

import ru.otus.hw10.model.Book;

import java.util.List;

public interface BookService {
    void saveBook(Book book);
    Book getBook(int id);
    void deleteBook(int id);
    List<Book> getAllBooks();
    long count();
    void editBook(Book book);
}
