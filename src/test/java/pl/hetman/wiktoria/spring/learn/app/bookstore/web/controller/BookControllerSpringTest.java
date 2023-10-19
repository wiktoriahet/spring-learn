package pl.hetman.wiktoria.spring.learn.app.bookstore.web.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookControllerSpringTest {

    @Autowired
    private BookController bookController;

    @Test
    void read() {
        //given
        BookModel bookModel = new BookModel();

        //when
        String read = bookController.read(bookModel);

        //then
        Assertions.assertNotNull(read, "read is null");


    }

    @Test
    void create() {
    }
}