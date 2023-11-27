package pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.BookEntity;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;

@SpringBootTest
class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void from() {
        //given
        BookModel bookModel = new BookModel();
        bookModel.setId(9L);
        bookModel.setTitle("Title");
        bookModel.setPages(100);

        //when
        BookEntity mappedBookEntity = bookMapper.from(bookModel);

        //then
        Assertions.assertNotNull(mappedBookEntity, "mappedBookEntity is null");
        Assertions.assertNotNull(mappedBookEntity.getTitle(), "mappedBookEntity.getTitle() is null");

    }
}