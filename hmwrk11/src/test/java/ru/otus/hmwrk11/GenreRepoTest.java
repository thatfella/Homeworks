package ru.otus.hmwrk11;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.otus.hmwrk11.dao.GenreRepo;
import ru.otus.hmwrk11.model.Genre;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class GenreRepoTest {

    @Autowired
    private GenreRepo repo;

    private Genre genre;

    @Before
    public void prepopulateAuthors() {
        genre = repo.save(new Genre(1, "testGenre")).block();
    }

    @Test
    public void checkIfAuthorSaved() {
        Mono<Genre> authorMono = repo.save(new Genre(5, "testGenre"));
        StepVerifier.create(authorMono).assertNext(genre -> assertNotNull(genre.getid())).expectComplete().verify();
    }

    @Test
    public void checkDelete() {
        assertEquals(0, repo.count().block().intValue());
    }

    @Test
    public void checkCount() {
        assertTrue(repo.count().block().intValue()> 0);
    }
}
