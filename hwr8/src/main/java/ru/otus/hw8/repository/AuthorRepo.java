package ru.otus.hw8.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw8.model.Author;

public interface AuthorRepo extends MongoRepository<Author,Long> {
}
