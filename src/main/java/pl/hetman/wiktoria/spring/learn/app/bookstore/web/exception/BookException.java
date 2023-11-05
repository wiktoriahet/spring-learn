package pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception;

public class BookException extends Exception{
    public BookException(String message) {
        super(message);
    }

    public BookException(String message, Throwable cause) {
        super(message, cause);
    }
}
