package pl.hetman.wiktoria.spring.learn.app.bookstore.web.model;

public class ErrorModel<T> {
    private T t;
    private String message;

    public ErrorModel(T t, String message) {
        this.t = t;
        this.message = message;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorModel{" +
                "t=" + t +
                ", message='" + message + '\'' +
                '}';
    }
}

