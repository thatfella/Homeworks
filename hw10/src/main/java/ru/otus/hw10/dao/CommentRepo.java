package ru.otus.hw10.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw10.model.Comment;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByBookId(int bookId);
}
