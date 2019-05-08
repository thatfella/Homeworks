package ru.otus.hmwrk11.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.hmwrk11.model.Author;


public interface AuthorRepo extends ReactiveMongoRepository<Author,Long> {
}
