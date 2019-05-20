package ru.otus.hw12;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.hw12.controller.AuthorController;
import ru.otus.hw12.service.AuthorRepo;
import ru.otus.hw12.service.BookRepo;
import ru.otus.hw12.service.GenreRepo;
import ru.otus.hw12.service.UserRepo;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@EnableMongoRepositories()
@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthenticationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MongoTemplate mongoTemplate;

    @MockBean
    private AuthorRepo authorRepo;

    @MockBean
    private GenreRepo genreRepo;

    @MockBean
    private BookRepo bookRepo;

    @MockBean
    private UserRepo userRepo;

    @Test
    public void testAuthentication() throws Exception {
   mockMvc.perform(formLogin("/allAuthors").user("user1").password("pass1")).andExpect(redirectedUrl("http://localhost/login"));
    }
}
