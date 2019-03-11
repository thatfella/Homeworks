package ru.otus.hw6.dao.impl;

import org.springframework.stereotype.Repository;
import ru.otus.hw6.dao.CommentRepo;
import ru.otus.hw6.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class CommentRepository implements CommentRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Comment findCommentById(int id) {
        return entityManager.find(Comment.class, id);
    }

    @Override
    public void insertComment(Comment comment) {
        entityManager.merge(comment);
    }

    @Override
    public void deleteComment(int id) {
        entityManager.remove(findCommentById(id));
    }

    public List<Comment> getCommentsToBook(int bookId) {
        return entityManager.createQuery("select c from Comment c where book_id = :id", Comment.class)
                .setParameter("id", bookId)
                .getResultList();
    }
}
