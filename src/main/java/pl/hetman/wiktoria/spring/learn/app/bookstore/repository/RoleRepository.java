package pl.hetman.wiktoria.spring.learn.app.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.RoleEntity;

@Repository //nie trzeba ale można
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
