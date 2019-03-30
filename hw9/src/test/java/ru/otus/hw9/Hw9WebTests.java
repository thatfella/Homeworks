package ru.otus.hw9;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ru.otus.hw9.controller.AuthorController;
import ru.otus.hw9.model.Author;
import ru.otus.hw9.service.AuthorService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class Hw9WebTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AuthorService authorService;


    @Test
    public void testAdditionForm() throws Exception {
        mvc.perform(get("/addauthor")).andExpect(status().isOk());
    }

    @Test
    public void testById() throws Exception {
        authorMock();
        mvc.perform(get("/author?id=1")).andExpect(status().isOk()).andDo(print())
                .andExpect(model().attributeExists("author"));
    }

    @Test
    public void test() throws Exception {

        authorMock();
        mvc.perform(get("/allAuthors")).andExpect(status().isOk());
    }

    private void authorMock() throws Exception {
        when(authorService.getAuthor(1)).thenReturn(new Author(1, "author"));
        authorService.getAuthor(1);
    }
}
