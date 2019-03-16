package ru.otus.hw8.service;

import ru.otus.hw8.model.Comment;

import java.util.List;

public interface CommentService {
    void saveComment(String text, long bookId);
    Comment getComment(long id);
    void deleteComment(long id);
    List<Comment> getAllComments();
    long count();
    List<Comment> getAllCommentByBookId(long bookId);
}
