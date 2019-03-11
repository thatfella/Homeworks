package ru.otus.hw6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.hw6.dao.AuthorRepo;
import ru.otus.hw6.dao.impl.AuthorRepository;
import ru.otus.hw6.model.Author;

@Service
public class AuthorService {
    private AuthorRepository authorRepo;

    @Autowired
    public AuthorService(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public void saveAuthor(Author author) {
        authorRepo.insertAuthor(author);
    }

    public void deleteAuthor(int id) {
        authorRepo.deleteAuthor(id);
    }

    public Author getAuthor(int id) {
        return authorRepo.findAuthorById(id);
    }

    public void getAllAuthors() {
        System.out.println(authorRepo.getAllAuthors());
    }

}
