package pl.hetman.wiktoria.spring.learn.app.bookstore.web.spring_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.controller.BookController;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception.BookException;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.BookService;

import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//todo nie działa i nie wiem czemu
@WebMvcTest(BookController.class)
public class BookControllerWebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void test() throws BookException, Exception {

        BookModel bookModel = new BookModel();
        //bookModel.setIsbn(IsbnGenerator.generateIsbn());
        bookModel.setTitle("Title title");
        bookModel.setPages("230");

        when(bookService.create(bookModel)).thenReturn(Optional.of(bookModel));
        this.mockMvc
                .perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Create a book")));

    }

}
