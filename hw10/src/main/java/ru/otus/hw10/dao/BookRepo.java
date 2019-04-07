package ru.otus.hw10.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw10.model.Book;

public interface BookRepo extends JpaRepository<Book,Integer> {

}
