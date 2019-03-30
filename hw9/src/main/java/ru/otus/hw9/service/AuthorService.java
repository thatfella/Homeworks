package ru.otus.hw9.service;

import ru.otus.hw9.model.Author;

import java.util.List;

public interface AuthorService {
     Author saveAuthor(int id, String name);
     Author getAuthor(int id);
     void deleteAuthor(int id);
     List<Author> getAllAuthors();
     long count();
     void editAuthor(Author author);

}
