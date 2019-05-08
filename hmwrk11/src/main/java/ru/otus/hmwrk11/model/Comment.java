package ru.otus.hmwrk11.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
public class Comment {

    @Id
    private long commentid;

    @Field("text")
    private String text;
    @DBRef
    private Book book;


    public Comment() {
    }

    public Comment(long commentid, String text, Book book) {
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

    public Comment(long commentid, String text) {
        this.commentid = commentid;
        this.text = text;
    }

    public long getCommentid() {
        return commentid;
    }

    public void setCommentid(long commentid) {
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
