package ru.otus.hw8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.hw8.model.Author;
import ru.otus.hw8.repository.AuthorRepo;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    private AuthorRepo authorRepo;

    @Override
    public void saveAuthor(long id, String name) {
        authorRepo.insert(new Author(id,name));
    }

    @Override
    public Author getAuthor(long id) {
        return authorRepo.findById(id).get();
    }

    @Override
    public void deleteAuthor(long id) {
        authorRepo.deleteById(id);
    }

    @Override
    public List<Author> getAllAuthors() {

        System.out.println(authorRepo.findAll());
        return authorRepo.findAll();
    }

    @Override
    public long count() {
        return 0;
    }
}
