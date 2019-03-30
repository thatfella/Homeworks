package ru.otus.hw9.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw9.model.Genre;

public interface GenreRepo extends JpaRepository <Genre, Integer>{

}
