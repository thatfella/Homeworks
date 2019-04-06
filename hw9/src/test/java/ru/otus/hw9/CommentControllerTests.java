package ru.otus.hw9;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.hw9.controller.CommentController;
import ru.otus.hw9.controller.GenreController;
import ru.otus.hw9.model.Book;
import ru.otus.hw9.model.Comment;
import ru.otus.hw9.model.Genre;
import ru.otus.hw9.service.AuthorService;
import ru.otus.hw9.service.BookService;
import ru.otus.hw9.service.CommentService;
import ru.otus.hw9.service.GenreService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
public class CommentControllerTests {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private CommentService commentService;

    @MockBean
    BookService bookService;

    @MockBean
    private AuthorService authorService;
    @MockBean
    private GenreService genreService;

    @Test
    public void testAdditionForm() throws Exception {
        mvc.perform(get("/addcomment")).andExpect(status().isOk());
    }

    @Test
    public void testById() throws Exception {
        commentMock();
        mvc.perform(get("/comment?id=1")).andExpect(status().isOk()).andDo(print())
                .andExpect(model().attributeExists("comment"));
    }

    @Test
    public void test() throws Exception {

        commentMock();
        mvc.perform(get("/allComments")).andExpect(status().isOk());
    }

    private void commentMock() throws Exception {
        when(commentService.getComment(1)).thenReturn(new Comment(1, "ok",new Book(1, "Book",1,1)));
        commentService.getComment(1);
    }
}
