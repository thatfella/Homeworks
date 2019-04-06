package ru.otus.hw9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.hw9.dao.BookRepo;
import ru.otus.hw9.model.Book;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql(scripts = "classpath:sql-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepoTest {


    @Autowired
    BookRepo bookRepo;



    @Test
    public void insertBook() {
        Book book = new Book(2, "TestBook", 2, 1);
        bookRepo.save(book);
        assertThat("TestBook").isEqualTo(bookRepo.findById(2).get().getName());
    }

    @Test
    public void deleteBook() {
        Book book = new Book(2, "TestBook2", 2, 1);
        bookRepo.save(book);
        bookRepo.deleteById(2);
        assertThat(bookRepo.findAll().size()).isEqualTo(1);
    }

    @Test
    public void getAllBooks() {
        assertThat(bookRepo.findAll().size()).isEqualTo(1);
    }

    @Test
    public void findBookById() {
        assertThat((bookRepo.findById(1).get().getName())).isEqualTo("The Road Back");
    }



}
