package pl.hetman.wiktoria.spring.learn.app.bookstore.web.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception.BookException;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void create() throws BookException {
        //given
        BookModel bookModel = new BookModel();
        bookModel.setId(9L);
        bookModel.setTitle("Title");
        bookModel.setPages(100);

        //when
        BookModel savedBookModel = bookService.create(bookModel);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedBookModel, "savedBookModel"),
                () -> Assertions.assertNotNull(savedBookModel.getTitle(), "savedBookModel.getTitle()")
        );
    }
}