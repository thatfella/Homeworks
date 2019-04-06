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

public class AuthorRepoTest {

	@Autowired
	AuthorRepo authorRepo;


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

}
