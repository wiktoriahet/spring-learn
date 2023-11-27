package pl.hetman.wiktoria.spring.learn.app.shelter.web.exception;

public class CatException extends Exception{
    public CatException(String message) {
        super(message);
    }

    public CatException(String message, Throwable cause) {
        super(message, cause);
    }
}
