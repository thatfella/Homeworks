package ru.otus.hw10.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.hw10.dao.BookRepo;
import ru.otus.hw10.model.Book;
import ru.otus.hw10.service.BookService;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void saveBook(Book book) {
        bookRepo.save(book);
    }

    @Override
    public Book getBook(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteBook(int id) {
        bookRepo.delete(getBook(id));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public void editBook(Book book) {
        bookRepo.save(book);
    }

    @Override
    public long count() {
        return bookRepo.count();
    }
}
