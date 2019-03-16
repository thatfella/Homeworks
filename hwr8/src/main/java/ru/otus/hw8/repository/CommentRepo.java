package ru.otus.hw8.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw8.model.Comment;

import java.util.List;

public interface CommentRepo extends MongoRepository<Comment, Long> {
    List<Comment> findAllByBookId(long bookId);
}
