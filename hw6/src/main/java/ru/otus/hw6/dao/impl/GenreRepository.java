package ru.otus.hw6.dao.impl;

import org.springframework.stereotype.Repository;
import ru.otus.hw6.dao.GenreRepo;
import ru.otus.hw6.model.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class GenreRepository implements GenreRepo {
    @PersistenceContext
    private EntityManager entityManager;


    public void insert(Genre genre) {
        entityManager.merge(genre);
    }

    public void deleteGenre(int id) {
        Genre genre = entityManager.find(Genre.class, id);
        entityManager.remove(genre);
    }

    public Genre findGenreById(int id) {
        return entityManager.find(Genre.class, id);
    }

    public List<Genre> getAllGenres() {
        TypedQuery<Genre> query = entityManager.createQuery("select g from Genre g", Genre.class);
        return query.getResultList();
    }

}
