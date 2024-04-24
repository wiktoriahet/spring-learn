package pl.hetman.wiktoria.spring.learn.app.bookstore.web.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception.BookException;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception.BookNotFoundException;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/books")
public class BookWebController {
    public static final Logger LOGGER = Logger.getLogger(BookWebController.class.getName());

    private BookService bookService; //dependency
    private List<BookModel> books = new ArrayList<>();

    public BookWebController(BookService bookService) { //injection
        this.bookService = bookService;
    }

    //http://localhost:8080/books?title=Vampire&pages=230
    @GetMapping
    //public void read(String title, String pages) {
    public String read(BookModel bookModel) throws BookException {
//        LOGGER.info("read(" + title + ")");
//        LOGGER.info("read(" + pages + ")");
        LOGGER.info("read(" + bookModel + ")");
        bookService.read(bookModel.getId());
        LOGGER.info("read(...)");
        return "app/bookstore/books.html";
    }

    @GetMapping(value = "/create")
    //@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book doesn't exist")
    public String createView(ModelMap modelMap) throws BookNotFoundException {
        LOGGER.info("createView()");

        modelMap.addAttribute("book", new BookModel());

        LOGGER.info("createView(...)");
        //throw new BookNotFoundException("Book not found");
        return "app/bookstore/create-book.html";
    }

    @PostMapping
    public String create(
            @Valid @ModelAttribute(name = "book") BookModel book,
            BindingResult bindingResult)
            throws BookException {
        //public String create(String title, Integer pages) {
        LOGGER.info("create(" + book + ")");
//        LOGGER.info("create(" + title + ")");
//        LOGGER.info("create(" + pages + ")");
        //books.add(book);
        if (bindingResult.hasErrors()) {
            LOGGER.warning("ERRORS!!! " + bindingResult.getAllErrors());
            return "app/bookstore/create-book.html";
        }
        bookService.create(book);
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

