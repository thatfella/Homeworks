package ru.otus.hw5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.hw5.dao.impl.AuthorRepositoryJdbc;
import ru.otus.hw5.dao.impl.BookRepositoryJdbc;
import ru.otus.hw5.dao.impl.GenreRepositoryJdbc;
import ru.otus.hw5.model.Author;
import ru.otus.hw5.model.Book;
import ru.otus.hw5.model.Genre;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JdbcTest
@TestPropertySource("classpath:application-test.properties")
@Sql(scripts = "classpath:sql-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Import({AuthorRepositoryJdbc.class, GenreRepositoryJdbc.class, BookRepositoryJdbc.class})

public class CommonDaoTests {
    @Autowired
    AuthorRepositoryJdbc authorRepositoryJdbc;
    @Autowired
    GenreRepositoryJdbc genreRepositoryJdbc;
    @Autowired
    BookRepositoryJdbc bookRepositoryJdbc;

    @Test
    public void insertAuthor() {
        Author author1 = new Author(6661, "Dante");
        authorRepositoryJdbc.insertAuthor(author1);
        assertThat("Dante").isEqualTo(authorRepositoryJdbc.findAuthorById(6661).getAuthorname());
    }

    @Test
    public void deleteAuthor() {
        authorRepositoryJdbc.insertAuthor(new Author(9, "Lafore"));
        authorRepositoryJdbc.deleteAuthor(9);
        System.out.println(authorRepositoryJdbc.getAllAuthors());
        assertThat(authorRepositoryJdbc.getAllAuthors().size()).isEqualTo(4);
    }

    @Test
    public void findAuthorById() {
        Author author1 = new Author(999, "Homer");
        authorRepositoryJdbc.insertAuthor(author1);
        assertThat("Homer").isEqualTo(authorRepositoryJdbc.findAuthorById(999).getAuthorname());
    }

    @Test
    public void insert() {
        Genre genre = new Genre(6666, "Poetry");
        genreRepositoryJdbc.insert(genre);
        assertThat("Poetry").isEqualTo(genreRepositoryJdbc.findGenreById(6666).getGenreName());
    }

    @Test
    public void deleteGenre() {
        genreRepositoryJdbc.insert(new Genre(9, "Bio"));
        genreRepositoryJdbc.deleteGenre(9);
        System.out.println(genreRepositoryJdbc.getAllGenres());
        assertThat(genreRepositoryJdbc.getAllGenres().size()).isEqualTo(2);
    }

    @Test
    public void findGenreById() {
        Genre genre = new Genre(999, "Science");
        genreRepositoryJdbc.insert(genre);
        assertThat("Science").isEqualTo(genreRepositoryJdbc.findGenreById(999).getGenreName());
    }

    @Test
    public void getAllGenres() {
        //return genreRepositoryJdbc.query("select * from genre", new GenreMapper());
        assertThat(genreRepositoryJdbc.getAllGenres().size()).isEqualTo(2);
    }

    @Test
    public void insertBook() {
        Book book = new Book(1111, "TestBook", 1, 1);
        bookRepositoryJdbc.insertBook(book);
        assertThat("TestBook").isEqualTo(bookRepositoryJdbc.findBookById(1111).getName());
    }

    @Test
    public void deleteBook() {
        Book book = new Book(1112, "TestBook2", 1, 1);
        bookRepositoryJdbc.insertBook(book);
        bookRepositoryJdbc.deleteBook(1112);
        assertThat(bookRepositoryJdbc.getAllBooks().size()).isEqualTo(1);
    }

    @Test
    public void getAllBooks() {
        assertThat(bookRepositoryJdbc.getAllBooks().size()).isEqualTo(1);
    }

    @Test
    public void findBookById() {
        assertThat((bookRepositoryJdbc.findBookById(1).getName())).isEqualTo("The Road Back");
    }

    @Test
    public void getAllBooksByAuthorId() {
        assertThat(bookRepositoryJdbc.getAllBooksByAuthorId(1).size()).isEqualTo(1);
    }
}
