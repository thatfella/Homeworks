package ru.otus.hw12.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw12.model.Genre;



public interface GenreRepo extends MongoRepository<Genre, Long> {

}
