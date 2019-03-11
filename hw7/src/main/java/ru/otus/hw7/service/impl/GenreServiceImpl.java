package ru.otus.hw7.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.hw7.dao.GenreRepo;
import ru.otus.hw7.model.Genre;
import ru.otus.hw7.service.GenreService;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private GenreRepo genreRepo;

    @Autowired
    public GenreServiceImpl(GenreRepo genreRepo) {
        this.genreRepo = genreRepo;
    }


    @Override
    public void saveGenre(int genreId, String genreName) {
        genreRepo.save(new Genre(genreId, genreName));
    }

    @Override
    public Genre getGenre(int id) {
        return genreRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteGenre(int id) {
        genreRepo.delete(getGenre(id));
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepo.findAll();
    }

    @Override
    public long count() {
        return genreRepo.count();
    }
}
