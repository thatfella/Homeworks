package ru.otus.hw6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.hw6.dao.GenreRepo;
import ru.otus.hw6.model.Genre;

@Service
public class GenreService {
    private GenreRepo genreRepo;

    @Autowired
    public GenreService(GenreRepo genreRepo) {
        this.genreRepo = genreRepo;
    }

    public void insertGenre(Genre genre) {
        genreRepo.insert(genre);
    }

    public Genre findGenre(int id) {
        return genreRepo.findGenreById(id);
    }

    public void deleteGenre(int id) {
        genreRepo.deleteGenre(id);
    }
}
