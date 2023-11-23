package pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BookEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Integer pages;

    public BookEntity() {
    }
}
