package ru.otus.hw12.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Genre {

    public Genre() {
    }

    @Id
    private long id;

    private String genreName;

    public Genre(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Genre :" +
                "genreId:" + id +
                ", genreName:'" + genreName + '\'';
    }

    public Genre(long genreId, String genreName) {
        this.id = genreId;
        this.genreName = genreName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
