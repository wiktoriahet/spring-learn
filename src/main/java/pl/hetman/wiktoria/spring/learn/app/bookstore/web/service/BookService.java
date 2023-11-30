package pl.hetman.wiktoria.spring.learn.app.bookstore.web.service;

import org.springframework.stereotype.Service;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.BookSpringRepository;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.BookEntity;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception.BookException;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.mapper.BookMapper;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookService {

    private static final Logger LOGGER = Logger.getLogger(BookService.class.getName());

    private BookSpringRepository bookSpringRepository;
    private BookMapper bookMapper;

    public BookService(BookSpringRepository bookSpringRepository, BookMapper bookMapper) {
        this.bookSpringRepository = bookSpringRepository;
        this.bookMapper = bookMapper;
    }

    public BookModel create(BookModel bookModel) throws BookException {
        LOGGER.info("create(" + bookModel + ")");

        BookEntity bookEntity = bookMapper.from(bookModel);
        BookEntity savedBookEntity = bookSpringRepository.save(bookEntity);
        BookModel savedBookModel = bookMapper.from(savedBookEntity);

        LOGGER.info("create(...)");
        return savedBookModel;
    }


    public BookModel read(Long id) {
        LOGGER.info("read(" + id + ")");
//        bookSpringRepository.read(id);
        LOGGER.info("read(...)");
        return null;
    }

    public BookModel update(Long id, BookModel bookModel) {
        LOGGER.info("update(" + id + ", " + bookModel + ")");
        LOGGER.info("update(...)");
        return null;
    }

    public boolean delete(Long id) {
        LOGGER.info("delete(" + id + ")");
        LOGGER.info("delete(...)");
        return false;
    }

    public List<BookModel> list() {
        return null;
    }


}
