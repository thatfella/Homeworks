package ru.otus.hw10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw10.model.Book;
import ru.otus.hw10.model.Comment;
import ru.otus.hw10.service.BookService;
import ru.otus.hw10.service.CommentService;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;
    private final BookService bookService;

    @Autowired
    public CommentController(CommentService commentService, BookService bookService) {
        this.commentService = commentService;
        this.bookService = bookService;
    }

    @RequestMapping("/comments/{id}")
    public Comment getComment(@RequestParam(value = "id") int id) {
        return  commentService.getComment(id);
    }


    @PostMapping("/comments")
    public Comment addCommentSubmit(@RequestBody Comment comment) {
         commentService.saveComment(comment);
         return comment;
    }


    @GetMapping("/comments")
    public List<Comment> allComments () {
        List<Comment> comments = commentService.getAllComments();
        return comments;
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable(value = "id") int id) {
        commentService.deleteComment(id);
    }


    @PutMapping("/comments/{id}")
    public String editCommentSubmit(@RequestParam(value = "id") int id, @RequestBody Comment comment) {
        commentService.updateComment(comment);
        return "getComment";
    }

}
