package pl.hetman.wiktoria.spring.learn.app.bookstore.web.repository;

import org.springframework.stereotype.Component;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Component
public class BookRepository implements Repository<BookModel> {

    private static final Logger LOGGER = Logger.getLogger(BookRepository.class.getName());

    @Override
    public Optional<BookModel> create(BookModel bookModel) {
        LOGGER.info("create("+ bookModel +")");
        LOGGER.info("create(...)");
        return Optional.empty();
    }

    @Override
    public Optional<BookModel> read(Long id) {
        LOGGER.info("read("+ id +")");
        LOGGER.info("read(...)");
        return Optional.empty();
    }

    @Override
    public Optional<BookModel> update(BookModel bookModel) {
        LOGGER.info("update("+ bookModel +")");
        LOGGER.info("update(...)");
        return Optional.empty();
    }

    @Override
    public boolean delete(BookModel bookModel) {
        LOGGER.info("delete("+ bookModel +")");
        LOGGER.info("delete(...)");
        return false;
    }

    @Override
    public List<BookModel> list() {
        return null;
    }
}
