package ru.otus.hw10.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.hw10.dao.AuthorRepo;
import ru.otus.hw10.model.Author;
import ru.otus.hw10.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepo authorRepo;

    @Autowired
    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author saveAuthor(int id, String name) {
        return authorRepo.save(new Author(id, name));
    }

    public void deleteAuthor(int id) {
        authorRepo.deleteById(id);
    }

    public Author getAuthor(int id) {
        return authorRepo.findById(id).orElse(null);
    }

    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public long count() {
        return authorRepo.count();
    }

    @Override
    public void editAuthor(Author author) {
        authorRepo.save(author);
    }

}
