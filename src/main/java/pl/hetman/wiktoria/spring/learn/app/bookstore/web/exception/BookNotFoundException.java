package pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book doesn't exist")
//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book doesn't exist")
public class BookNotFoundException extends BookException {

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
