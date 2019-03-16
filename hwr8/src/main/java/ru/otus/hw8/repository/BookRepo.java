package ru.otus.hw8.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw8.model.Book;

public interface BookRepo extends MongoRepository<Book,Long> {

}
