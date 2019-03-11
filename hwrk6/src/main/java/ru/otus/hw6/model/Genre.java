package ru.otus.hw6.model;

import javax.persistence.*;

@Entity
@Table(name = "Genre")
public class Genre {

    public Genre() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genreid")
    private int genreId;

    private String genreName;


    @Override
    public String toString() {
        return "Genre :" +
                "genreId:" + genreId +
                ", genreName:'" + genreName + '\'';
    }

    public Genre(int genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
    }

    public Genre(int genreId) {
        this.genreId = genreId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
