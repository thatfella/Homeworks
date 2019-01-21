package ru.otus.hw5.dao;

import ru.otus.hw5.model.Genre;

public interface GenreRepo {
        public Genre findGenreById(int id);
        public void insert(Genre genre);
        public void deleteGenre (int id);
}
