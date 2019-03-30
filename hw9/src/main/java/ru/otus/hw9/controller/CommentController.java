package ru.otus.hw9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw9.model.Book;
import ru.otus.hw9.model.Comment;
import ru.otus.hw9.service.BookService;
import ru.otus.hw9.service.CommentService;

import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;
    private final BookService bookService;

    @Autowired
    public CommentController(CommentService commentService, BookService bookService) {
        this.commentService = commentService;
        this.bookService = bookService;
    }

    @RequestMapping("/comment")
    public String getComment(@RequestParam(value = "id") int id, Model model) {
        Comment comment = commentService.getComment(id);
        model.addAttribute("comment",comment);
        return "getComment";
    }

    @GetMapping("/addcomment")
    public String addCommentForm(Model model) {
        model.addAttribute("comment", new Comment());
        List<Book> bookList = bookService.getAllBooks();
        model.addAttribute("books", bookList);
        return "addComment";
    }

    @PostMapping("/addcomment")
    public String addCommentSubmit(@ModelAttribute Comment comment) {
        commentService.saveComment(comment.getText(),comment.getBook().getId());
        return "added";
    }


    @GetMapping("/allComments")
    public String allComments (Model model) {
        List<Comment> comments = commentService.getAllComments();
        model.addAttribute("comments", comments);
        return "allComments";
    }

    @RequestMapping("/deleteComment")
    public String deleteComment(@RequestParam(value = "id") int id) {
        commentService.deleteComment(id);
        return "deleted";
    }

    @GetMapping("/editcomment")
    public String editComment(@RequestParam(value = "id") int id, Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        Comment comment= commentService.getComment(id);
        model.addAttribute("comment", comment);
        return "editComment";
    }

    @PostMapping("/editcomment")
    public String editCommentSubmit(@ModelAttribute Comment comment) {
        commentService.updateComment(comment);
        return "getComment";
    }

}
