package ru.otus.hw9;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.hw9.controller.GenreController;
import ru.otus.hw9.model.Genre;
import ru.otus.hw9.service.GenreService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GenreController.class)
public class GenreControllerTests {



        @Autowired
        private MockMvc mvc;

        @MockBean
        private GenreService genreService;



        @Test
        public void testAdditionForm() throws Exception {
            mvc.perform(get("/addgenre")).andExpect(status().isOk());
        }

        @Test
        public void testById() throws Exception {
            authorMock();
            mvc.perform(get("/genre?id=1")).andExpect(status().isOk()).andDo(print())
                    .andExpect(model().attributeExists("genre"));
        }

        @Test
        public void test() throws Exception {

            authorMock();
            mvc.perform(get("/allGenres")).andExpect(status().isOk());
        }

        private void authorMock() throws Exception {
            when(genreService.getGenre(1)).thenReturn(new Genre(1, "genre"));
            genreService.getGenre(1);
        }
    }


