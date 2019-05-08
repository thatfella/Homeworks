package ru.otus.hmwrk11;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.otus.hmwrk11.dao.BookRepo;
import ru.otus.hmwrk11.model.Book;
import ru.otus.hmwrk11.model.Genre;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class BookRepoTest {

    @Autowired
    private BookRepo repo;

    private Book book;

    @Before
    public void prepopulateAuthors() {
        book = repo.save(new Book(1, "test",1,1)).block();
    }

    @Test
    public void checkIfAuthorSaved() {
        Mono<Book> authorMono = repo.save(new Book(5, "testbook",1,1));
        StepVerifier.create(authorMono).assertNext(book -> assertNotNull(book.getName())).expectComplete().verify();
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
