package ru.otus.hw9.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw9.model.Comment;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByBookId(int bookId);
}
