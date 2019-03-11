package ru.otus.hw6.dao;

import ru.otus.hw6.model.Book;

public interface BookRepo {
    Book findBookById(int id);

    void insertBook(Book book);

    void deleteBook(int id);
}
