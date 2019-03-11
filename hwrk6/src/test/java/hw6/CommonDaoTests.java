package hw6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.hw6.dao.impl.AuthorRepository;
import ru.otus.hw6.dao.impl.BookRepository;
import ru.otus.hw6.dao.impl.CommentRepository;
import ru.otus.hw6.dao.impl.GenreRepository;
import ru.otus.hw6.model.Author;
import ru.otus.hw6.model.Book;
import ru.otus.hw6.model.Comment;
import ru.otus.hw6.model.Genre;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:sql-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ComponentScan(basePackages = "ru.otus")
@Import({AuthorRepository.class, GenreRepository.class, BookRepository.class, CommentRepository.class})
public class CommonDaoTests {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CommentRepository commentRepository;


    @Test
    public void insertAuthor() {
        Author author1 = new Author(3, "Dante");
        authorRepository.insertAuthor(author1);
        assertThat("Dante").isEqualTo(authorRepository.findAuthorById(3).getAuthorname());
    }

    @Test
    public void deleteAuthor() {
        authorRepository.insertAuthor(new Author(3, "Lafore"));
        authorRepository.deleteAuthor(3);
        System.out.println(authorRepository.getAllAuthors());
        assertThat(authorRepository.getAllAuthors().size()).isEqualTo(2);
    }

    @Test
    public void findAuthorById() {
        Author author1 = new Author(3, "Homer");
        authorRepository.insertAuthor(author1);
        assertThat("Homer").isEqualTo(authorRepository.findAuthorById(3).getAuthorname());
    }

    @Test
    public void insert() {
        Genre genre = new Genre(2, "Poetry");
        genreRepository.insert(genre);
        assertThat("Poetry").isEqualTo(genreRepository.findGenreById(2).getGenreName());
    }

    @Test
    public void deleteGenre() {
        genreRepository.insert(new Genre(2, "Bio"));
        genreRepository.deleteGenre(2);
        System.out.println(genreRepository.getAllGenres());
        assertThat(genreRepository.getAllGenres().size()).isEqualTo(1);
    }

    @Test
    public void findGenreById() {
        Genre genre = new Genre(2, "Science");
        genreRepository.insert(genre);
        assertThat("Science").isEqualTo(genreRepository.findGenreById(2).getGenreName());
    }

    @Test
    public void getAllGenres() {
        assertThat(genreRepository.getAllGenres().size()).isEqualTo(1);
    }

    @Test
    public void insertBook() {
        Book book = new Book(2, "TestBook", 2, 1);
        bookRepository.insertBook(book);
        assertThat("TestBook").isEqualTo(bookRepository.findBookById(2).getName());
    }

    @Test
    public void deleteBook() {
        Book book = new Book(2, "TestBook2", 2, 1);
        bookRepository.insertBook(book);
        bookRepository.deleteBook(2);
        assertThat(bookRepository.getAllBooks().size()).isEqualTo(1);
    }

    @Test
    public void getAllBooks() {
        assertThat(bookRepository.getAllBooks().size()).isEqualTo(1);
    }

    @Test
    public void findBookById() {
        assertThat((bookRepository.findBookById(1).getName())).isEqualTo("The Road Back");
    }

    @Test
    public void insertComment() {
        commentRepository.insertComment(new Comment(2,"Good"));
        assertThat("Good".equals(commentRepository.findCommentById(2).getText()));
    }
    @Test
    public void findCommentById(){
        assertThat("Awesome".equals(commentRepository.findCommentById(1).getText()));
    }
    @Test
    public void deleteComment() {
        commentRepository.insertComment(new Comment(2,"Good"));
        commentRepository.deleteComment(2);
        assertThat(commentRepository.findCommentById(2) == null);
    }


    @Test
    public void getCommentsByBook() {
        Book book = bookRepository.findBookById(1);
        commentRepository.insertComment(new Comment(2,"Good",book));
        assertThat(2 == (commentRepository.getCommentsToBook(2).size()));
    }

}
