package ru.otus.hw8.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw8.model.Genre;

public interface GenreRepo extends MongoRepository<Genre, Long> {

}
