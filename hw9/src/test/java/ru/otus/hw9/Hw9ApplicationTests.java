package ru.otus.hw9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.hw9.dao.AuthorRepo;
import ru.otus.hw9.dao.BookRepo;
import ru.otus.hw9.dao.CommentRepo;
import ru.otus.hw9.dao.GenreRepo;
import ru.otus.hw9.model.Author;
import ru.otus.hw9.model.Book;
import ru.otus.hw9.model.Comment;
import ru.otus.hw9.model.Genre;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql(scripts = "classpath:sql-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

public class Hw9ApplicationTests {

	@Autowired
	CommentRepo commentRepo;
	@Autowired
	BookRepo bookRepo;
	@Autowired
	AuthorRepo authorRepo;
	@Autowired
	GenreRepo genreRepo;

	@Test
	public void insertAuthor() {
		Author author = new Author(3, "Dante");
		authorRepo.save(author);
		assertEquals(3, authorRepo.count());
	}

	@Test
	public void deleteAuthor() {
		authorRepo.save(new Author(3, "Lafore"));
		authorRepo.deleteById(3);
		System.out.println(authorRepo.findAll());
		assertThat(authorRepo.findAll().size()).isEqualTo(2);
	}

	@Test
	public void findAuthorById() {
		Author author1 = new Author(3, "Homer");
		authorRepo.save(author1);
		assertThat("Homer").isEqualTo(authorRepo.findById(3).get().getAuthorname());
	}

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

	@Test
	public void insertComment() {
		commentRepo.save(new Comment(2,"Good"));
		assertThat("Good".equals(commentRepo.findById(2).get().getText()));
	}
	@Test
	public void findCommentById(){
		assertThat("Awesome".equals(commentRepo.findById(1).get().getText()));
	}
	@Test
	public void deleteComment() {
		commentRepo.save(new Comment(2,"Good"));
		commentRepo.deleteById(2);
		assertThat(!commentRepo.findById(2).isPresent());
	}


	@Test
	public void getCommentsByBook() {
		Book book = bookRepo.findById(1).get();
		commentRepo.save(new Comment(2,"Good",book));
		assertThat(2 == (commentRepo.findAllByBookId(1).size()));
	}

}
