package ru.otus.hmwrk11;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.otus.hmwrk11.dao.AuthorRepo;
import ru.otus.hmwrk11.model.Author;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class AuthorRepoTest {

    @Autowired
    private AuthorRepo repo;

    private Author author;

    @Before
    public void prepopulateAuthors() {
        author = repo.save(new Author(1, "test")).block();
    }

    @Test
    public void checkIfAuthorSaved() {
        Mono<Author> authorMono = repo.save(new Author(5, "Tolstoy"));
        StepVerifier.create(authorMono).assertNext(author -> assertNotNull(author.getId())).expectComplete().verify();
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
