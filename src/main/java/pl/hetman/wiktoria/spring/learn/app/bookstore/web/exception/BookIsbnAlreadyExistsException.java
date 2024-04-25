package pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception;

//@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Book with this ISBN already exists")
public class BookIsbnAlreadyExistsException extends BookException {

    public BookIsbnAlreadyExistsException(String message) {
        super(message);
    }

    public BookIsbnAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}
