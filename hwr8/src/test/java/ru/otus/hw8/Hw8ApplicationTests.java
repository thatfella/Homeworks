package ru.otus.hw8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.hw8.model.Author;
import ru.otus.hw8.model.Book;
import ru.otus.hw8.model.Comment;
import ru.otus.hw8.model.Genre;
import ru.otus.hw8.repository.AuthorRepo;
import ru.otus.hw8.repository.BookRepo;
import ru.otus.hw8.repository.CommentRepo;
import ru.otus.hw8.repository.GenreRepo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class Hw8ApplicationTests {

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
		assertEquals(4, authorRepo.count());
	}

	@Test
	public void deleteAuthor() {
		authorRepo.save(new Author(3, "Lafore"));
		authorRepo.deleteById((long) 3);
		System.out.println(authorRepo.findAll());
		assertThat(authorRepo.findAll().size()).isEqualTo(3);
	}

	@Test
	public void findAuthorById() {
		Author author1 = new Author(3, "Homer");
		authorRepo.save(author1);
		assertThat("Homer").isEqualTo(authorRepo.findById(3L).get().getName());
	}

	@Test
	public void insert() {
		Genre genre = new Genre(2, "Poetry");
		genreRepo.save(genre);
		assertThat("Poetry").isEqualTo(genreRepo.findById(2L).get().getGenreName());
	}

	@Test
	public void deleteGenre() {
		genreRepo.save(new Genre(2, "Bio"));
		genreRepo.deleteById(2L);
		System.out.println(genreRepo.findAll());
		assertThat(genreRepo.findAll().size()).isEqualTo(1);
	}

	@Test
	public void findGenreById() {
		Genre genre = new Genre(2, "Science");
		genreRepo.save(genre);
		assertThat("Science").isEqualTo(genreRepo.findById(2L).get().getGenreName());
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
		assertThat("TestBook").isEqualTo(bookRepo.findById(2L).get().getName());
	}

	@Test
	public void deleteBook() {
		Book book = new Book(2, "TestBook2", 2, 1);
		bookRepo.save(book);
		bookRepo.deleteById(2L);
		assertThat(bookRepo.findAll().size()).isEqualTo(1);
	}

	@Test
	public void getAllBooks() {
		assertThat(bookRepo.findAll().size()).isEqualTo(1);
	}

	@Test
	public void findBookById() {
		assertThat((bookRepo.findById((long) 1).get().getName())).isEqualTo("book1");
	}

	@Test
	public void insertComment() {
		commentRepo.save(new Comment(2,"Good"));
		assertThat("Good".equals(commentRepo.findById(2L).get().getText()));
	}
	@Test
	public void findCommentById(){
		assertNotNull((commentRepo.findById((long) 0).get().getText()));
	}
	@Test
	public void deleteComment() {
		commentRepo.save(new Comment(2,"Good"));
		commentRepo.deleteById(2L);
		assertThat(!commentRepo.findById(2L).isPresent());
	}


	@Test
	public void getCommentsByBook() {
		Book book = bookRepo.findById(1L).get();
		commentRepo.save(new Comment(2,"Good",book));
		assertThat(2 == (commentRepo.findAllByBookId(1).size()));
	}

}
