package pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.BookEntity;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;

import java.util.logging.Logger;

@Component
public class BookMapper {
    private static Logger LOGGER = Logger.getLogger(BookMapper.class.getName());

    public BookEntity from(BookModel bookModel) {
        LOGGER.info("from("+bookModel+")");
        ModelMapper modelMapper = new ModelMapper();
        BookEntity mappedBookEntity = modelMapper.map(bookModel, BookEntity.class);

//        BookEntity bookEntity = new BookEntity();

//        bookEntity.setId(bookModel.getId());
//        bookEntity.setTitle(bookModel.getTitle());
//        bookEntity.setPages(bookModel.getPages());
        LOGGER.info("from()");
        return mappedBookEntity;
    }

    public BookModel from(BookEntity bookEntity){
        LOGGER.info("from("+bookEntity+")");
        ModelMapper modelMapper = new ModelMapper();
        BookModel mappedBookModel = modelMapper.map(bookEntity, BookModel.class);
        LOGGER.info("from(...)");
        return mappedBookModel;
    }
    // TODO: 30.11.2023 dodać konfigurację model mapper strict

// TODO: 23.11.2023 zamienić implementację metody from na użycie ModelMapper [?]
    //https://modelmapper.org/ [x]
    //stworzyć repository i service dla wybranego modelu [x]
    //loggery
    //przenieść do social-act-tr
}
