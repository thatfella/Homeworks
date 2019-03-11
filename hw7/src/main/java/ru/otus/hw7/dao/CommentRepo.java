package ru.otus.hw7.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw7.model.Comment;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByBookId(int bookId);
}
