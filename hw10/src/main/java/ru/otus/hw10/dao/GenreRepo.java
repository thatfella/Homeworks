package ru.otus.hw10.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw10.model.Genre;

public interface GenreRepo extends JpaRepository <Genre, Integer>{

}
