package pl.hetman.wiktoria.spring.learn.app.bookstore.web.service;

import org.springframework.stereotype.Service;
import pl.hetman.wiktoria.spring.learn.app.bookstore.isbngenerator.IsbnGenerator;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.BookSpringRepository;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.BookEntity;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.exception.BookException;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.model.BookModel;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.mapper.BookMapper;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BookService {

    private static final Logger LOGGER = Logger.getLogger(BookService.class.getName());

    private BookSpringRepository bookSpringRepository;
    private BookMapper vipBookMapper;

    public BookService(BookSpringRepository bookSpringRepository, BookMapper vipBookMapper) {
        this.bookSpringRepository = bookSpringRepository;
        this.vipBookMapper = vipBookMapper;
    }

    public Optional<BookModel> create(BookModel bookModel) throws BookException {
        LOGGER.info("create(" + bookModel + ")");

        String isbn = bookModel.getIsbn();
        if (isbn == null) {

            String randomIsbn = IsbnGenerator.generateIsbn();
            bookModel.setIsbn(randomIsbn);

            BookEntity bookEntity = vipBookMapper.from(bookModel);
            BookEntity savedBookEntity = bookSpringRepository.save(bookEntity);
            BookModel savedBookModel = vipBookMapper.from(savedBookEntity);

            LOGGER.info("create(...) = " + Optional.of(savedBookModel));
            return Optional.of(savedBookModel);
        } else {
            BookEntity foundBookEntity = bookSpringRepository.findByIsbnIs(isbn);
            if (foundBookEntity != null) {
                throw new BookException("Isbn already exists");
            } else {
                BookEntity bookEntity = vipBookMapper.from(bookModel);
                BookEntity savedBookEntity = bookSpringRepository.save(bookEntity);
                BookModel savedBookModel = vipBookMapper.from(savedBookEntity);

                LOGGER.info("create(...) = " + Optional.of(savedBookModel));
                return Optional.of(savedBookModel);
            }
        }

//        LOGGER.info("create(...) = " + Optional.empty());
//        return null;
    }

    public BookModel read(Long id) throws BookException {
        LOGGER.info("read(" + id + ")");
        Optional<BookEntity> optionalBookEntity = bookSpringRepository.findById(id);
        BookEntity bookEntity = optionalBookEntity.orElseThrow(
                () -> new BookException("Book with given id does not exist: " + id));
        BookModel bookModel = vipBookMapper.from(bookEntity);
        LOGGER.info("read(...) = " + bookModel);
        return bookModel;
    }

    public Optional<BookModel> update(Long id, BookModel bookModel) throws BookException {
        LOGGER.info("update(" + id + ", " + bookModel + ")");
        if (id == null) {
            throw new BookException("Book with given id does not exist: " + id);
        } else  if (bookModel == null) {
            throw new BookException("Given bookModel does not exist");
        } else {
            bookModel.setId(id);
            BookEntity bookEntity = vipBookMapper.from(bookModel);
            BookEntity updatedBookEntity = bookSpringRepository.save(bookEntity);
            BookModel updatedBookModel = vipBookMapper.from(updatedBookEntity);

            LOGGER.info("update(...)");
            return Optional.of(updatedBookModel);
        }
    }

    public boolean delete(Long id) throws BookException {
        LOGGER.info("delete(" + id + ")");
//        if (id == null) {
//            throw new BookException("Book with given id does not exist: " + id);
//        } else {
        bookSpringRepository.deleteById(id);
        LOGGER.info("delete(...)");
        return true;
        //}
    }

    public List<BookModel> list() {
        return null;
    }


}
