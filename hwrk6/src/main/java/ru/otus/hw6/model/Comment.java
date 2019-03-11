package ru.otus.hw6.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentid")
    private int commentid;

    @Column
    private String text;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "bookId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Book book;


    public Comment() {
    }

    public Comment(int commentid, String text, Book book) {
        this.commentid = commentid;
        this.text = text;
        this.book = book;
    }

    public Comment(String text, Book book) {
        this.text = text;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentid=" + commentid +
                ", text='" + text + '\'' +
                '}';
    }

    public Comment(int commentid, String text) {
        this.commentid = commentid;
        this.text = text;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
