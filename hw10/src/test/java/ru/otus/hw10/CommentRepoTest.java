package ru.otus.hw10;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.hw10.dao.BookRepo;
import ru.otus.hw10.dao.CommentRepo;
import ru.otus.hw10.model.Book;
import ru.otus.hw10.model.Comment;
import ru.otus.hw10.service.AuthorService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql(scripts = "classpath:sql-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CommentRepoTest {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    BookRepo bookRepo;

    @MockBean
    private AuthorService authorService;


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
