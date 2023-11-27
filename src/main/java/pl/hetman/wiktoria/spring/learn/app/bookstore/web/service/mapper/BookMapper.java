package pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.BookEntity;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;

@Component
public class BookMapper {

    ModelMapper modelMapper = new ModelMapper();

    public BookEntity from(BookModel bookModel) {

        BookEntity mappedBookEntity = modelMapper.map(bookModel, BookEntity.class);

//        BookEntity bookEntity = new BookEntity();

//        bookEntity.setId(bookModel.getId());
//        bookEntity.setTitle(bookModel.getTitle());
//        bookEntity.setPages(bookModel.getPages());

        return mappedBookEntity;
    }
// TODO: 23.11.2023 zamienić implementację metody from na użycie ModelMapper
    //https://modelmapper.org/
    //stworzyć repository i service dla wybranego modelu
    //przenieść do social-act-tr
}