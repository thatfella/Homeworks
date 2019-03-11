package ru.otus.hw7.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.hw7.model.Genre;

import java.util.List;

public interface GenreRepo extends JpaRepository <Genre, Integer>{

}
