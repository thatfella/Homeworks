package ru.otus.hw6.dao.impl;


import org.springframework.stereotype.Repository;
import ru.otus.hw6.dao.AuthorRepo;
import ru.otus.hw6.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class AuthorRepository implements AuthorRepo {

    @PersistenceContext
    private EntityManager entityManager;


    public Author findAuthorById(int authorid) {
        return entityManager.find(Author.class, authorid);
    }

    public void insertAuthor(Author author) {
        entityManager.merge(author);
    }

    @Transactional
    public void updateAuthor(int id, String newName) {
        Author author = findAuthorById(id);
        author.setAuthorname(newName);
        entityManager.merge(author);
    }

    @Transactional
    public void deleteAuthor(int id) {
        Author author = findAuthorById(id);
        entityManager.remove(author);
    }

    public List<Author> getAllAuthors() {
        Query query = entityManager.createNativeQuery("select * from Author", Author.class);
        return query.getResultList();
    }

}
