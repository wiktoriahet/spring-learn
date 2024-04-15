package pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.RoleRepository;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.SpringLearnUserRepository;

@SpringBootTest
class SpringLearnUserEntityTest {

    @Autowired
    private SpringLearnUserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testUserWithoutRoles() {
        //given
        SpringLearnUserEntity springLearnUserEntity = new SpringLearnUserEntity();

        //when
        SpringLearnUserEntity savedUserEntity = userRepository.save(springLearnUserEntity);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedUserEntity, "savedUserEntity is null"),
                () -> Assertions.assertNotNull(savedUserEntity.getId(), "savedUserEntity.getId() is null")
        );
    }

    @Test
    public void testUserWithRoles() {
        //given
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(RoleNameType.ADMIN.name());

        SpringLearnUserEntity springLearnUserEntity = new SpringLearnUserEntity();
        //springLearnUserEntity.getRoles().add(roleEntity);
        springLearnUserEntity.add(roleEntity);

        //when
//        RoleEntity savedRoleEntity = roleRepository.save(roleEntity);
//        springLearnUserEntity.getRoles().add(savedRoleEntity);
        SpringLearnUserEntity savedUserEntity = userRepository.save(springLearnUserEntity);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(savedUserEntity, "savedUserEntity is null"),
                () -> Assertions.assertNotNull(savedUserEntity.getId(), "savedUserEntity.getId() is null")
        );
    }
}