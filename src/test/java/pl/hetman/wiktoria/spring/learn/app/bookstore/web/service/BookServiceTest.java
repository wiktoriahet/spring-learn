package pl.hetman.wiktoria.spring.learn.app.bookstore.web.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.spring.learn.app.bookstore.isbngenerator.IsbnGenerator;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception.BookException;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;

import java.util.Optional;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void create() throws BookException {
        //given
        BookModel bookModel = new BookModel();
        bookModel.setIsbn(IsbnGenerator.generateIsbn().toString());
        bookModel.setTitle("Title 1");
        bookModel.setPages(150);

        //when
        Optional<BookModel> createdBookModelOptional = bookService.create(bookModel);
        BookModel createdBookModel = createdBookModelOptional.get();



        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdBookModelOptional, "createdBookModelOptional is null"),
                () -> Assertions.assertNotNull(createdBookModel, "createdBookModel is null"),
                () -> Assertions.assertNotNull(createdBookModel.getIsbn(), "createdBookModel.getIsbn() is null")
        );
    }
}
// TODO: 30.11.2023 create tests for all if-s in BookService (4)