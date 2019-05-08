package ru.otus.hmwrk11.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.hmwrk11.model.Book;

public interface BookRepo extends ReactiveMongoRepository<Book,Long> {

}
