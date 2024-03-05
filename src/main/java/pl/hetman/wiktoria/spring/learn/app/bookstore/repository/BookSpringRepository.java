package pl.hetman.wiktoria.spring.learn.app.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.BookEntity;

@Repository
public interface BookSpringRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findByIsbnIs(String isbn); // derived query method
    //https://docs.spring.io/spring-data/jpa/reference/repositories/query-methods-details.html
    //https://www.baeldung.com/spring-data-derived-queries

//
//    Optional<T> create(T t);
//
//    Optional<T> read(Long id);
//
//    Optional<T> update(T t);
//
//    boolean delete(T t);
//
//    List<T> list ();
}
