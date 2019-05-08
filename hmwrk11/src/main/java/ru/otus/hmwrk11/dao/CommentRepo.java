package ru.otus.hmwrk11.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.hmwrk11.model.Comment;

import java.util.List;

public interface CommentRepo extends ReactiveMongoRepository<Comment, Long> {
    List<Comment> findAllByBookId(long bookId);
}
