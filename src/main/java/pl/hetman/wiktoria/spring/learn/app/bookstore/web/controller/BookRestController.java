package pl.hetman.wiktoria.spring.learn.app.bookstore.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception.BookException;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.ErrorModel;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.BookService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
//@Controller
@RequestMapping(value = "/api/v1/books")
public class BookRestController {
    public static final Logger LOGGER = Logger.getLogger(BookRestController.class.getName());

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookModel> list() {
        return List.of(
                new BookModel(),
                new BookModel()
        );
    }

    @PostMapping
    //@ResponseBody
    public BookModel create(@RequestBody BookModel bookModel) throws BookException {
        LOGGER.info("create(" + bookModel + ")");

        Optional<BookModel> optionalBookModel = bookService.create(bookModel);
        BookModel createdBookModel = optionalBookModel.orElseThrow(
                () -> new BookException("Can't create a book."));

        LOGGER.info("create(...) = " + createdBookModel);
        return createdBookModel;
    }

    @GetMapping("/{id}")
    // public BookModel read(@PathVariable Long id) throws BookException {
    public ResponseEntity<?> read(@PathVariable Long id) {
        LOGGER.info("read(" + id + ")");

        BookModel readBook = null;
        try {
            readBook = bookService.read(id);
        } catch (BookException e) {
            return new ResponseEntity<>(new ErrorModel(readBook, "Not found"), HttpStatus.NO_CONTENT);
        }

        LOGGER.info("read(...) = " + readBook);
        return new ResponseEntity<>(readBook, HttpStatus.OK);
    }

}
