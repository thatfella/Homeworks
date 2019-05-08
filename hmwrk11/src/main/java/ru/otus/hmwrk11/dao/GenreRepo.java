package ru.otus.hmwrk11.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.hmwrk11.model.Genre;

public interface GenreRepo extends ReactiveMongoRepository<Genre, Long> {

}
