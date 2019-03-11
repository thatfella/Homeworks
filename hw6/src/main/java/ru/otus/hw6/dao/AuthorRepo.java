package ru.otus.hw6.dao;

import ru.otus.hw6.model.Author;

public interface AuthorRepo {
    Author findAuthorById(int id);

    void insertAuthor(Author author);

    void deleteAuthor(int id);
}
