package pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        BookEntity mappedBookEntity = modelMapper.map(bookModel, BookEntity.class);
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

    //https://modelmapper.org/ [x]

}
