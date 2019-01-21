package ru.otus.hw5.model;

public class Genre {
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
