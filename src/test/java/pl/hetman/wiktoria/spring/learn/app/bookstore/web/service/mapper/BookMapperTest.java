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
    private BookMapper vipBookMapper;

    public BookMapper getVipBookMapper() {
        return vipBookMapper;
    }

    @Autowired
    public void setVipBookMapper(BookMapper vipBookMapper) {
        this.vipBookMapper = vipBookMapper;
    }

    @Test
    void fromEntityToModel() {
        //given
        BookModel bookModel = new BookModel();
        bookModel.setId(9L);
        bookModel.setTitle("Title");
        bookModel.setPages("100");

        //when
        BookEntity mappedBookEntity = vipBookMapper.from(bookModel);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(mappedBookEntity, "mappedBookEntity is null"),
                () -> Assertions.assertNotNull(mappedBookEntity.getTitle(), "mappedBookEntity.getTitle() is null")
        );
    }

    @Test
    void fromModelToEntity() {
        //given
        BookModel bookModel = new BookModel();
        bookModel.setId(9L);
        bookModel.setTitle("Title");
        bookModel.setPages("100");
        BookEntity mappedBookEntity = vipBookMapper.from(bookModel);

        //when
        BookModel mapppedBookModel = vipBookMapper.from(mappedBookEntity);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(mapppedBookModel, "mapppedBookModel is null"),
                () -> Assertions.assertNotNull(mapppedBookModel.getTitle(), "mapppedBookModel.getTitle() is null")
        );

    }
}