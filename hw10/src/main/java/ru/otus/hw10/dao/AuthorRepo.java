package ru.otus.hw10.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw10.model.Author;

public interface AuthorRepo extends JpaRepository<Author,Integer> {

}
