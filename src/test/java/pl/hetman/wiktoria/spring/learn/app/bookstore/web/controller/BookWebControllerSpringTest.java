package pl.hetman.wiktoria.spring.learn.app.bookstore.web.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception.BookException;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;

@SpringBootTest
class BookWebControllerSpringTest {

    @Autowired
    private BookWebController bookWebController;

    @Test
    void read() throws BookException {
        //given
        BookModel bookModel = new BookModel();

        //when
        String read = bookWebController.read(bookModel);

        //then
        Assertions.assertNotNull(read, "read is null");


    }
    //todo https://spring.io/guides/gs/testing-web/ dla book controller
    // napisać 3 rodzaje testów
    // z artykułu [x]

    @Test
    void create() {
    }
}