package ru.otus.hw6.dao;

import ru.otus.hw6.model.Comment;

import java.util.List;

public interface CommentRepo {
    Comment findCommentById(int id);

    void insertComment(Comment comment);

    void deleteComment(int id);

    List<Comment> getCommentsToBook(int id);
}
