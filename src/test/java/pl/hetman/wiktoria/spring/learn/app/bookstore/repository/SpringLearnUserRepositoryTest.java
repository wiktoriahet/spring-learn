package pl.hetman.wiktoria.spring.learn.app.bookstore.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.SpringLearnUserEntity;

import java.util.Optional;

@SpringBootTest
class SpringLearnUserRepositoryTest {

    public static final String PASSWORD = "p4$$w0rd";
    @Autowired
    private SpringLearnUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void create() {
        //given


        SpringLearnUserEntity userEntity = new SpringLearnUserEntity();
        userEntity.setUsername("maupka123");
        String encodedPassword = passwordEncoder.encode(PASSWORD);
        userEntity.setPassword(encodedPassword);



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
        Optional<SpringLearnUserEntity> optionalFoundUserEntity = userRepository.findById(savedUserEntity.getId());
        SpringLearnUserEntity foundUserEntity = optionalFoundUserEntity.orElse(null);

        //then
        Assertions.assertNotNull(foundUserEntity, "foundUserEntity is null");

    }
}