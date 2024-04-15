package pl.hetman.wiktoria.spring.learn.app.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.SpringLearnUserEntity;

public interface SpringLearnUserRepository extends JpaRepository<SpringLearnUserEntity, Long> {

    SpringLearnUserEntity findByUsername(String username);

}
