package ru.otus.hw8.model;

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
                "id:" + id +
                ", genreName:'" + genreName + '\'';
    }

    public Genre(long id, String genreName) {
        this.id = id;
        this.genreName = genreName;
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
