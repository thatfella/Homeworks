package ru.otus.hw5.dao;

import ru.otus.hw5.model.Author;

public interface AuthorRepo {
    public Author findAuthorById(int id);
    public void insertAuthor(Author author);
    public void deleteAuthor (int id);
}
