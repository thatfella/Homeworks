package ru.otus.hw10.service;

import ru.otus.hw10.model.Comment;

import java.util.List;

public interface CommentService {
    void saveComment(Comment comment);
    Comment getComment(int id);
    void deleteComment(int id);
    List<Comment> getAllComments();
    long count();
    List<Comment> getAllCommentByBookId(int bookId);
    void updateComment(Comment comment);
}
