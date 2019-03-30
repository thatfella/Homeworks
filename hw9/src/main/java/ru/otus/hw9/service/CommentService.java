package ru.otus.hw9.service;

import ru.otus.hw9.model.Comment;

import java.util.List;

public interface CommentService {
    void saveComment(String text, int bookId);
    Comment getComment(int id);
    void deleteComment(int id);
    List<Comment> getAllComments();
    long count();
    List<Comment> getAllCommentByBookId(int bookId);
    void updateComment(Comment comment);
}
