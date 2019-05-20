package ru.otus.hw12.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw12.model.Author;

//@Repository
public interface AuthorRepo extends MongoRepository<Author,Long> {
}
