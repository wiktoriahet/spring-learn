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
        BookModel createdBookModel = createdBookModelOptional.orElse(null);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdBookModelOptional, "createdBookModelOptional is null"),
                () -> Assertions.assertNotNull(createdBookModel, "createdBookModel is null"),
                () -> Assertions.assertNotNull(createdBookModel.getIsbn(), "createdBookModel.getIsbn() is null")
        );
    }

    @Test
    void createWithNullIsbn() throws BookException {
        //given
        BookModel bookModel = new BookModel();
        bookModel.setIsbn(null);
        bookModel.setTitle("Title 1");
        bookModel.setPages(150);

        //when
        Optional<BookModel> createdBookModelOptional = bookService.create(bookModel);
        BookModel createdBookModel = createdBookModelOptional.orElse(new BookModel());
        String isbn = createdBookModel.getIsbn();

        //then
        Assertions.assertNotNull(isbn, "isbn is null");
    }

    @Test
    void createIsbnAlreadyExists() {
        //given
        BookModel bookModel = new BookModel();
        bookModel.setIsbn("978-83-142305-2-1");
        bookModel.setTitle("Title 1");
        bookModel.setPages(150);

        //when
        Optional<BookModel> createdBookModelOptional = null;

        //then
        // FIXME: użyć assertThrows() [x]

        Assertions.assertThrows(BookException.class,
                () -> bookService.create(bookModel));
    }
}
// TODO: 30.11.2023 create tests for all if-s in BookService (x)