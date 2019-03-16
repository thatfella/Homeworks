package ru.otus.hw8.service;

import ru.otus.hw8.model.Genre;

import java.util.List;

public interface GenreService {
    void saveGenre(long genreId, String genreName);
    Genre getGenre(long id);
    void deleteGenre(long id);
    List<Genre> getAllGenres();
    long count();
}
