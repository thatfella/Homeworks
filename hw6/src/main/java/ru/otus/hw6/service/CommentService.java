package ru.otus.hw6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.hw6.dao.BookRepo;
import ru.otus.hw6.dao.CommentRepo;
import ru.otus.hw6.model.Book;
import ru.otus.hw6.model.Comment;

import java.util.List;

@Service
public class CommentService {

    private CommentRepo commentRepo;

    private BookRepo bookRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo, BookRepo bookRepo) {
        this.commentRepo = commentRepo;
        this.bookRepo = bookRepo;
    }

    public void insertComment(String comment, int bookid) {
        Book book = bookRepo.findBookById(bookid);
        commentRepo.insertComment(new Comment(comment, book));
    }

    public Comment findComment(int id) {
        return commentRepo.findCommentById(id);
    }

    public void deleteComment(int id) {
        commentRepo.deleteComment(id);
    }

    public List<Comment> getCommentsToBook(int id) {
        return commentRepo.getCommentsToBook(id);
    }
}
