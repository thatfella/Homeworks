package ru.otus.hw7.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw7.model.Author;

public interface AuthorRepo extends JpaRepository <Author,Integer> {

}
