package ru.otus.hw9;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.hw9.dao.GenreRepo;
import ru.otus.hw9.model.Genre;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql(scripts = "classpath:sql-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GenreRepoTest {


    @Autowired
    GenreRepo genreRepo;


    @Test
    public void insert() {
        Genre genre = new Genre(2, "Poetry");
        genreRepo.save(genre);
        assertThat("Poetry").isEqualTo(genreRepo.findById(2).get().getGenreName());
    }

    @Test
    public void deleteGenre() {
        genreRepo.save(new Genre(2, "Bio"));
        genreRepo.deleteById(2);
        System.out.println(genreRepo.findAll());
        assertThat(genreRepo.findAll().size()).isEqualTo(1);
    }

    @Test
    public void findGenreById() {
        Genre genre = new Genre(2, "Science");
        genreRepo.save(genre);
        assertThat("Science").isEqualTo(genreRepo.findById(2).get().getGenreName());
    }

    @Test
    public void getAllGenres() {
        //return genreRepository.query("select * from genre", new GenreMapper());
        assertThat(genreRepo.findAll().size()).isEqualTo(1);
    }


}
