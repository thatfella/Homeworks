package ru.otus.hw8.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.hw8.model.Book;
import ru.otus.hw8.repository.BookRepo;
import ru.otus.hw8.service.BookService;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    private BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void saveBook(long id, String name, long authorId, long genreId) {
        bookRepo.save(new Book(id, name, authorId, genreId));
    }

    @Override
    public Book getBook(long id) {
        return bookRepo.findById(id).orElse(null);
        //genreRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteBook(long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public long count() {
        return bookRepo.count();
    }
}
