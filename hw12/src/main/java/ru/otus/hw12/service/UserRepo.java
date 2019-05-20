package ru.otus.hw12.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw12.model.User;

public interface UserRepo extends MongoRepository<User, Long> {
    User findByUserName(String userName);
}
