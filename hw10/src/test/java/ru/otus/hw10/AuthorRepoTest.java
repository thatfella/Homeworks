package ru.otus.hw10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.hw10.dao.AuthorRepo;
import ru.otus.hw10.model.Author;
import ru.otus.hw10.service.AuthorService;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql(scripts = "classpath:sql-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepoTest {

	@Autowired
	AuthorRepo authorRepo;

	@MockBean
	private AuthorService authorService;



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
