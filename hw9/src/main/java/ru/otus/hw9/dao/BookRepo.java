package ru.otus.hw9.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw9.model.Book;

public interface BookRepo extends JpaRepository<Book,Integer> {

}
