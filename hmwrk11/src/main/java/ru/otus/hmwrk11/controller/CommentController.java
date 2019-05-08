package ru.otus.hmwrk11.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hmwrk11.dao.CommentRepo;
import ru.otus.hmwrk11.model.Comment;

@RestController
public class CommentController {

    @Autowired
    private CommentRepo commentRepo;

    public void setCommentRepo(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @GetMapping("/comments/{id}")
    public Mono<Comment> getComment(@PathVariable long id) {
        return commentRepo.findById(id);
    }

    @PostMapping("/comments")
    public Mono<Comment> addCommentSubmit(@RequestBody Comment comment) {
        return commentRepo.save(comment);
    }

    @PutMapping("/comments/{id}")
    public Mono<Comment> editCommentSubmit(@PathVariable long id, @RequestBody Comment comment) {
        return commentRepo.findById(id).map(existingComment -> {
            if (comment.getText() != null) {
                existingComment.setText(comment.getText());
            }
            if (comment.getBook() != null) {
                existingComment.setBook(comment.getBook());
            }
            return existingComment;
        }).then(commentRepo.save(comment));
    }


    @GetMapping("/comments")
    public Flux<Comment> allComments() {
        return commentRepo.findAll();
    }


    @DeleteMapping("/comments/{id}")
    public Mono<Void> deleteComment(@PathVariable long id) {
        return commentRepo.deleteById(id);
    }

}
