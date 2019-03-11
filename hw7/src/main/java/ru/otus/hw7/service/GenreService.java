package ru.otus.hw7.service;

import ru.otus.hw7.model.Genre;
import java.util.List;

public interface GenreService {
    void saveGenre(int genreId, String genreName);
    Genre getGenre(int id);
    void deleteGenre(int id);
    List<Genre> getAllGenres();
    long count();
}
