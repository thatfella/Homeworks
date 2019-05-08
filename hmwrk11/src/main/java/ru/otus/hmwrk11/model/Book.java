package ru.otus.hmwrk11.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Book {

    public Book(long id, String name, Author author, Genre genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }


    public Book(long id, String name, long authorId, long genreId) {
        this.id = id;
        this.name = name;
        this.author = new Author(authorId);
        this.genre = new Genre(genreId);
    }


    @Id
    private long id;

    @DBRef
    private Genre genre;

    public Book() {
    }

    @DBRef
    private Author author;

    private String name;

    public Book(long id) {
        this.id = id;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book:" + this.getName() + " Author: " + this.getAuthor().getName() + " Genre: " + this.getGenre().getGenreName();
    }
}
