package pl.hetman.wiktoria.spring.learn.app.bookstore.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.SpringLearnUserEntity;

@SpringBootTest
class SpringLearnUserRepositoryTest {

    @Autowired
    SpringLearnUserRepository userRepository;

    @Test
    void create() {
        //given
        SpringLearnUserEntity userEntity = new SpringLearnUserEntity();
        userEntity.setUsername("maupka123");
        userEntity.setPassword("p4$$w0rd");

        //when
        SpringLearnUserEntity savedUserEntity = userRepository.save(userEntity);

        //then
        Assertions.assertNotNull(savedUserEntity, "savedUserEntity is null");

    }

    @Test
    void createAndFindById() {
        //given
        SpringLearnUserEntity userEntity = new SpringLearnUserEntity();
        userEntity.setUsername("maupka123");
        userEntity.setPassword("p4$$w0rd");

        SpringLearnUserEntity savedUserEntity = userRepository.save(userEntity);

        //when
        SpringLearnUserEntity foundUserEntity = userRepository.findByIdIs(savedUserEntity.getId());

        //then
        Assertions.assertNotNull(foundUserEntity, "foundUserEntity is null");

    }
}