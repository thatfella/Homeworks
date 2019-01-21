package ru.otus.hw5.dao;

import ru.otus.hw5.model.Book;

public interface BookRepo {
            public Book findBookById(int id);
            public void insertBook(Book book);
            public void deleteBook (int id);
}
