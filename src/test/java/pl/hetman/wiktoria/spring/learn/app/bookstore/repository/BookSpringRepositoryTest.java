package pl.hetman.wiktoria.spring.learn.app.bookstore.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.BookEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookSpringRepositoryTest {

    @Autowired
    private BookSpringRepository bookSpringRepository;

    @Test
    void create(){
        //given
        BookEntity entity = new BookEntity();

        //when
        BookEntity savedBookEntity = bookSpringRepository.save(entity);

        //then
        Assertions.assertNotNull(savedBookEntity, "savedBookEntity is null");

    }

}