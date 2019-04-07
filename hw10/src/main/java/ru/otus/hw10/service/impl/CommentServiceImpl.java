package ru.otus.hw10.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.hw10.dao.BookRepo;
import ru.otus.hw10.dao.CommentRepo;
import ru.otus.hw10.model.Book;
import ru.otus.hw10.model.Comment;
import ru.otus.hw10.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepo commentRepo;

    private BookRepo bookRepo;

    @Autowired
    public CommentServiceImpl(CommentRepo commentRepo, BookRepo bookRepo) {
        this.commentRepo = commentRepo;
        this.bookRepo = bookRepo;
    }


    @Override
    public void saveComment(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public Comment getComment(int id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteComment(int id) {
        commentRepo.delete(getComment(id));
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public long count() {
        return commentRepo.count();
    }

    @Override
    public List<Comment> getAllCommentByBookId(int bookId) {
        return commentRepo.findAllByBookId(bookId);
    }

    @Override
    public void updateComment(Comment comment) {
        commentRepo.save(comment);
    }
}
