package ru.otus.hw9.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw9.model.Author;

public interface AuthorRepo extends JpaRepository<Author,Integer> {

}
