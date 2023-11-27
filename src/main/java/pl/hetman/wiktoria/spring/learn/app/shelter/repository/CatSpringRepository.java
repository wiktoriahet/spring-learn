package pl.hetman.wiktoria.spring.learn.app.shelter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hetman.wiktoria.spring.learn.app.shelter.repository.entity.CatEntity;

@Repository
public interface CatSpringRepository extends JpaRepository<CatEntity, Long> {
}
