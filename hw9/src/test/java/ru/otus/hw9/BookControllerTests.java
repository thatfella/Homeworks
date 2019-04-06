package ru.otus.hw9;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.hw9.controller.BookController;
import ru.otus.hw9.model.Book;
import ru.otus.hw9.service.AuthorService;
import ru.otus.hw9.service.BookService;
import ru.otus.hw9.service.GenreService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;
    @MockBean
    private AuthorService authorService;
    @MockBean
    private GenreService genreService;

    @Before
    public void prepare() {
        authorService.saveAuthor(1, "author");
        genreService.saveGenre(1,"genre");
    }


    @Test
    public void testbookForm() throws Exception {
        bookMock();
        mvc.perform(get("/book?id=1")).andExpect(status().isOk());
    }

    @Test
    public void testById() throws Exception {
        bookMock();
        mvc.perform(get("/book?id=1")).andExpect(status().isOk()).andDo(print())
                .andExpect(model().attributeExists("book"));
    }

    @Test
    public void test() throws Exception {

        bookMock();
        mvc.perform(get("/allBooks")).andExpect(status().isOk());
    }

    private void bookMock() throws Exception {

        when(bookService.getBook(1)).thenReturn(new Book(1, "book",1,1));
        bookService.getBook(1);
    }
}
