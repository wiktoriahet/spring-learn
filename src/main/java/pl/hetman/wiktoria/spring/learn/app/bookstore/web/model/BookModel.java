package pl.hetman.wiktoria.spring.learn.app.bookstore.web.model;

import jakarta.validation.constraints.NotEmpty;

public class BookModel {
    //todo dodać walidację dla pages
    private Long id;
    private String isbn;
    @NotEmpty(message = "Wypełnij to pole!")
    private String title;
    @NotEmpty(message = "Wypełnij to pole!")
    private String pages;

    public BookModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }
}
