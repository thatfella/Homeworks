package ru.otus.hw6.dao.impl;

import org.springframework.stereotype.Repository;
import ru.otus.hw6.dao.BookRepo;
import ru.otus.hw6.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class BookRepository implements BookRepo {
    @PersistenceContext
    private EntityManager entityManager;

    public Book findBookById(int bookid) {
        return entityManager.find(Book.class, bookid);
    }

    public void insertBook(Book book) {
        entityManager.merge(book);
    }

    public void deleteBook(int id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
    }

    public List<Book> getAllBooks() {
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b", Book.class);
        return query.getResultList();
    }
}
