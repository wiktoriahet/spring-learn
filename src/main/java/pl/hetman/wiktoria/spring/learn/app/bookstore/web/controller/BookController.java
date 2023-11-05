package pl.hetman.wiktoria.spring.learn.app.bookstore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/books")
public class BookController {
    public static final Logger LOGGER = Logger.getLogger(BookController.class.getName());

    private BookService bookService; //dependency

    public BookController(BookService bookService) { //injection
        this.bookService = bookService;
    }

    private List<BookModel> books = new ArrayList<>();

    //http://localhost:8080/books?title=Vampire&pages=230
    @GetMapping
    //public void read(String title, String pages) {
    public String read(BookModel bookModel) {
//        LOGGER.info("read(" + title + ")");
//        LOGGER.info("read(" + pages + ")");
        LOGGER.info("read(" + bookModel + ")");
        bookService.read(bookModel.getId());
        LOGGER.info("read(...)");
        return "app/bookstore/books.html";
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");

        modelMap.addAttribute("book", new BookModel());

        LOGGER.info("createView(...)");
        return "app/bookstore/create-book.html";
    }

    @PostMapping
    public String create(BookModel bookModel) {
        //public String create(String title, Integer pages) {
        LOGGER.info("create(" + bookModel + ")");
//        LOGGER.info("create(" + title + ")");
//        LOGGER.info("create(" + pages + ")");
        books.add(bookModel);
        LOGGER.info("create(...)");
        //return "app/bookstore/books.html";
        return "redirect:/books/list";
    }

    @GetMapping(value = "/list")
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");
        modelMap.addAttribute("books", books);
        LOGGER.info("list(...)");
        return "app/bookstore/books.html";
    }
}

