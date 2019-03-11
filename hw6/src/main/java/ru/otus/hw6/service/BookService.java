package ru.otus.hw6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.hw6.dao.BookRepo;
import ru.otus.hw6.model.Book;


@Service
public class BookService {
    private BookRepo  bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void saveBook(Book book) {
        bookRepo.insertBook(book);
    }

    public void deleteBook(int id) {
        bookRepo.deleteBook(id);
    }

    public Book findBook(int id) {
        return bookRepo.findBookById(id);
    }

}
