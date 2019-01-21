package ru.otus.hw5.model;


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


    private String name;

    private int id;

    private Genre genre;

    private Author author;


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
        return "Book:" + this.getName() + " Author: " + this.getAuthor().getAuthorname()+ " Genre: "+ this.getGenre().getGenreName();
    }
}
