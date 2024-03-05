package pl.hetman.wiktoria.spring.learn.app.bookstore.web.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.BookSpringRepository;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception.BookException;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.BookService;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.mapper.BookMapper;

class BookWebControllerTest {

    @Test
    void read() throws BookException {
        //given
        BookSpringRepository bookRepository = null; // = new BookSpringRepository();
        BookMapper bookMapper = new BookMapper();
        BookService bookService = new BookService(bookRepository, bookMapper);
        BookWebController bookWebController = new BookWebController(bookService);

        BookModel bookModel = new BookModel();

        //when
        String read = bookWebController.read(bookModel);

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