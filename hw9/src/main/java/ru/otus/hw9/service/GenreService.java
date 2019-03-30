package ru.otus.hw9.service;

import ru.otus.hw9.model.Genre;

import java.util.List;

public interface GenreService {
    void saveGenre(int genreId, String genreName);
    Genre getGenre(int id);
    void deleteGenre(int id);
    List<Genre> getAllGenres();
    long count();
    void editGenre(Genre genre);

}
