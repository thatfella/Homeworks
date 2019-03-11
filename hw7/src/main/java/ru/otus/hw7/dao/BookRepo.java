package ru.otus.hw7.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw7.model.Book;

public interface BookRepo extends JpaRepository<Book,Integer> {

}
