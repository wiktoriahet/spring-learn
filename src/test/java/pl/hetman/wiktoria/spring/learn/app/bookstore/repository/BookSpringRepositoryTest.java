package pl.hetman.wiktoria.spring.learn.app.bookstore.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.spring.learn.app.bookstore.isbngenerator.IsbnGenerator;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.BookEntity;

@SpringBootTest
class BookSpringRepositoryTest {

    @Autowired
    private BookSpringRepository bookSpringRepository;

    @Test
    void create() {
        //given
        BookEntity entity = new BookEntity();
        entity.setIsbn(IsbnGenerator.generateIsbn().toString());
        entity.setPages(100);
        entity.setTitle("title");

        //when
        BookEntity savedBookEntity = bookSpringRepository.save(entity);

        //then
        Assertions.assertNotNull(savedBookEntity, "savedBookEntity is null");

    }

    @Test
    void createAndFindByIsbn() {
        //given
        BookEntity entity = new BookEntity();
        entity.setIsbn(IsbnGenerator.generateIsbn().toString());
        entity.setPages(200);
        entity.setTitle("new title");
        BookEntity savedBookEntity = bookSpringRepository.save(entity);

        //when
        BookEntity foundBookEntity = bookSpringRepository.findByIsbnIs(savedBookEntity.getIsbn());

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(foundBookEntity, "foundBookEntity is null")
        );

    }

}