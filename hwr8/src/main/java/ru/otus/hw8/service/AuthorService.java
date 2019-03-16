package ru.otus.hw8.service;

import ru.otus.hw8.model.Author;
import ru.otus.hw8.repository.AuthorRepo;

import java.util.List;

public interface AuthorService  {
    void saveAuthor(long id, String name);
    Author getAuthor(long id);
    void deleteAuthor (long id);
    List<Author> getAllAuthors();
    long count();

}
