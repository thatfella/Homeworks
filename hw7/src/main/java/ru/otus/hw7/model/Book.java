package ru.otus.hw7.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book {

    public Book(int id, String name, Author author, Genre genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }


    public Book(int id, String name, int authorId, int genreId) {
        this.id = id;
        this.name = name;
        this.author = new Author(authorId);
        this.genre = new Genre(genreId);
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(targetEntity = Genre.class)
    @JoinColumn(name = "genreid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Genre genre;

    public Book() {
    }

    @OneToOne(targetEntity = Author.class)
    @JoinColumn(name = "authorid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;

    private String name;

    public Book(int id) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book:" + this.getName() + " Author: " + this.getAuthor().getAuthorname() + " Genre: " + this.getGenre().getGenreName();
    }
}
