package ru.otus.hw6.dao;

import ru.otus.hw6.model.Genre;

import java.util.List;

public interface GenreRepo {
    Genre findGenreById(int id);

    void insert(Genre genre);

    void deleteGenre(int id);

    List<Genre> getAllGenres();
}
