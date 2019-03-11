package ru.otus.hw7.service;

import ru.otus.hw7.model.Author;

import java.util.List;

public interface AuthorService {
     void saveAuthor(int id, String name);
     Author getAuthor(int id);
     void deleteAuthor (int id);
     List<Author> getAllAuthors();
     long count();

}
