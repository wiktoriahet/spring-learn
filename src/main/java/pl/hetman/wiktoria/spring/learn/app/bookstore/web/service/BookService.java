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
    private BookMapper bookMapper;

    public BookService(BookSpringRepository bookSpringRepository, BookMapper bookMapper) {
        this.bookSpringRepository = bookSpringRepository;
        this.bookMapper = bookMapper;
    }

    // TODO: 30.11.2023 zamiast BookModel zwracać optional[x]
//    public BookModel create(BookModel bookModel) throws BookException {
//        LOGGER.info("create(" + bookModel + ")");
//
//        String isbn = bookModel.getIsbn();
//        if (isbn != null) {
//            // TODO: 30.11.2023 stworzyć oddzielną klasę generującą isbn[x]
//            //String randomIsbn = UUID.randomUUID().toString();
//            String randomIsbn = IsbnGenerator.generateIsbn().toString();
//            bookModel.setIsbn(randomIsbn);
//        } else {
//            BookEntity foundBookEntity = bookSpringRepository.findByIsbnIs(isbn);
//            if (foundBookEntity != null) {
//                throw new BookException("Isbn already exists");
//            } else {
//                BookEntity bookEntity = bookMapper.from(bookModel);
//                BookEntity savedBookEntity = bookSpringRepository.save(bookEntity);
//                BookModel savedBookModel = bookMapper.from(savedBookEntity);
//
//                LOGGER.info("create(...)");
//                return savedBookModel;
//            }
//        }
//
//        LOGGER.info("create(...) = " + null);
//        return null;
//    }

    public Optional<BookModel> create(BookModel bookModel) throws BookException {
        LOGGER.info("create(" + bookModel + ")");

        String isbn = bookModel.getIsbn();
        if (isbn == null) {
            // TODO: 30.11.2023 stworzyć oddzielną klasę generującą isbn[x]
            String randomIsbn = IsbnGenerator.generateIsbn().toString();
            bookModel.setIsbn(randomIsbn);

            BookEntity bookEntity = bookMapper.from(bookModel);
            BookEntity savedBookEntity = bookSpringRepository.save(bookEntity);
            BookModel savedBookModel = bookMapper.from(savedBookEntity);

            LOGGER.info("create(...) = " + Optional.of(savedBookModel));
            return Optional.of(savedBookModel);
        } else {
            BookEntity foundBookEntity = bookSpringRepository.findByIsbnIs(isbn);
            if (foundBookEntity != null) {
                throw new BookException("Isbn already exists");
            } else {
                BookEntity bookEntity = bookMapper.from(bookModel);
                BookEntity savedBookEntity = bookSpringRepository.save(bookEntity);
                BookModel savedBookModel = bookMapper.from(savedBookEntity);

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
        BookModel bookModel = bookMapper.from(bookEntity);
        LOGGER.info("read(...) = " + bookModel);
        return bookModel;
    }

    //todo 21.12.23 update i delete + testy
    public BookModel update(Long id, BookModel bookModel) {
        LOGGER.info("update(" + id + ", " + bookModel + ")");
        LOGGER.info("update(...)");
        return null;
    }

    public boolean delete(Long id) {
        LOGGER.info("delete(" + id + ")");
        LOGGER.info("delete(...)");
        return false;
    }

    public List<BookModel> list() {
        return null;
    }


}
