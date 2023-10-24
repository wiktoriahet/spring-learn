package pl.hetman.wiktoria.spring.learn.app.bookstore.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {
    private String title;
    private int pages;
}
