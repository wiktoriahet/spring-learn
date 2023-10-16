package pl.hetman.wiktoria.spring.learn.app.bookstore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/books")
public class BookController {
    public static final Logger LOGGER = Logger.getLogger(BookController.class.getName());

    //http://localhost:8080/books?title=Vampire&pages=230
    @GetMapping
    //public void read(String title, String pages) {
    public String read(BookModel bookModel) {
//        LOGGER.info("read(" + title + ")");
//        LOGGER.info("read(" + pages + ")");
        LOGGER.info("read(" + bookModel + ")");
        LOGGER.info("read(...)");
        return "app/bookstore/books.html";
    }

    @PostMapping
    public void create(BookModel bookModel){
        LOGGER.info("create(" + bookModel + ")");
        LOGGER.info("create(...)");
    }

}