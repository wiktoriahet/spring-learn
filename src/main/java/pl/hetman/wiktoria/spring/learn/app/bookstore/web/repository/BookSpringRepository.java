package pl.hetman.wiktoria.spring.learn.app.bookstore.web.repository;

import java.util.List;
import java.util.Optional;

public interface BookSpringRepository<T>{

    Optional<T> create(T t);

    Optional<T> read(Long id);

    Optional<T> update(T t);

    boolean delete(T t);

    List<T> list ();

}
