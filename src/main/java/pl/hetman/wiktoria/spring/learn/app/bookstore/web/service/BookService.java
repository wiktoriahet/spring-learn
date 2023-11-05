package pl.hetman.wiktoria.spring.learn.app.bookstore.web.service;

import org.springframework.stereotype.Service;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception.BookException;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.repository.BookRepository;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BookService {

    private static final Logger LOGGER = Logger.getLogger(BookService.class.getName());

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookModel create(BookModel bookModel) throws BookException {
        LOGGER.info("create("+ bookModel +")");

        Optional<BookModel> optionalBookModel =
                bookRepository.create(bookModel);

        BookModel createdBookModel = optionalBookModel.orElseThrow(
                ()->new BookException("Unable to create book")
        );

        LOGGER.info("create(...)");
        return createdBookModel;
    }


    public void read(){
        LOGGER.info("read()");
        bookRepository.read();
        LOGGER.info("read(...)");
    }

}
