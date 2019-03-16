package ru.otus.hw8.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.otus.hw8.model.Book;
import ru.otus.hw8.model.Comment;
import ru.otus.hw8.repository.BookRepo;
import ru.otus.hw8.repository.CommentRepo;
import ru.otus.hw8.service.CommentService;

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
    public void saveComment(String text, long bookId) {
        Book book = bookRepo.findById(bookId).get();
        commentRepo.save(new Comment(text,book));
    }

    @Override
    public Comment getComment(long id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteComment(long id) {
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
    public List<Comment> getAllCommentByBookId(long bookId) {
        return commentRepo.findAllByBookId(bookId);
    }
}
