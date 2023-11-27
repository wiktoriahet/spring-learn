package pl.hetman.wiktoria.spring.learn.app.bookstore.web.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.BookSpringRepository;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.BookService;

class BookControllerTest {

    @Test
    void read() {
        //given
        BookSpringRepository bookRepository = null; // = new BookSpringRepository();
        BookService bookService = new BookService(bookRepository);
        BookController bookController = new BookController(bookService);

        BookModel bookModel = new BookModel();

        //when
        String read = bookController.read(bookModel);

        //then
        Assertions.assertNotNull(read, "read is null");

    }

    @Test
    void create() {
        //given

        //when

        //then

    }
}