package ru.otus.hw12.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw12.model.Book;



public interface BookRepo extends MongoRepository<Book,Long> {

}
