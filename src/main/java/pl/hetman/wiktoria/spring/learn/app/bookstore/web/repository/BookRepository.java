package pl.hetman.wiktoria.spring.learn.app.bookstore.web.repository;

import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class BookRepository {

    private static final Logger LOGGER = Logger.getLogger(BookRepository.class.getName());

    public void read(){
        LOGGER.info("read()");
        LOGGER.info("read(...)");
    }

}
